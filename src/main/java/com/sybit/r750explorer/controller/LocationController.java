package com.sybit.r750explorer.controller;

/**
 * Created by fzr on 06.03.17.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sybit.airtable.vo.Attachment;
import com.sybit.r750explorer.repository.tables.Location;
import com.sybit.r750explorer.repository.tables.Medien;
import com.sybit.r750explorer.service.LocationService;
import com.sybit.r750explorer.service.MedienService;
import com.sybit.r750explorer.service.ScoreService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller to manage Locations.
 * * Overview
 * * JSON-Calls for AJAX requests
 * * detail page
 * 
 * @author ssr
 */
@Controller
@RequestMapping("/location")
public class LocationController {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LocationService locationService;

    @Autowired
    private ScoreService scoreService;
    
    @Autowired
    private MedienService medienService;

    /**
     * Location page with all sorted media.
     *
     * @param uuid Cookie-ID of the user
     * @param locationSlug URL part of Location
     * @param model Data-Model of HTML page
     * @param redirectAttr Attribute für Redirect.
     * 
     * @return location page will be called.
     */
    @RequestMapping(value = "/{slug}")
    public String getLocation(@CookieValue(value = "UUID",required = false) String uuid, @PathVariable("slug") String locationSlug, Map<String, Object> model, RedirectAttributes redirectAttr) {

        Location loc = locationService.getLocation(locationSlug);

        if (loc == null) {
            log.error("--> getLocation: Location not found! LocationSlug: " + locationSlug);
            redirectAttr.addFlashAttribute("message", "Ort leider nicht gefunden. Sie wurden auf die Startseite umgeleitet!");
            return "redirect:" + "/";
        }
        
        //TODO: Wurde die Location schon besucht und Fragen beantwortet?
        //model.put("QuizAnswered", true|false);
        
        List<Location> visited = locationService.getVisitedLocations(uuid);
        List<String> Locationid = new ArrayList<>();
        
        for (Location location : visited) {
            Locationid.add(location.getId());
        }
        
        if (Locationid.contains(loc.getId())) {
            model.put("QuizAnswered", true);
        } else {
            model.put("QuizAnswered", false);
        }
        
        List<Attachment> attList;
                
        //TODO: welche Medien hat die Location zum Anzeigen? Diese sortiert übergeben.
        List<Medien> medienList = medienService.getMedienOfLocationSlug(locationSlug);

        for (Medien a : medienList) {
            
            try {
                attList = a.getAttachements();
            } catch (NullPointerException e) {
                    redirectAttr.addFlashAttribute("message", "Sie wurden auf die Startseite umgeleitet!");
                    return "redirect:" + "/";
            }
        }
        
        //TODO: Daten an das Model übergeben.
            model.put("locationDescription", loc.getDescription());
            model.put("locationFoto", loc.getPhoto().get(0).getUrl());
            model.put("locationMedien", medienList);
            model.put("locationName", loc.getName());
            model.put("locationSlug", loc.getSlug());
            
        return "location";

    }

    /**
     * JSON formatted response for all Locations.
     * 
     * This method is called by JavaScript to fill Google Map.
     *
     * @param uuid Cookie-ID of the user
     * @return json-List of all Locations.
     */
    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllLocationsData(@CookieValue("UUID") String uuid) {

        log.debug("--> getAllLocationsData");

        List<Location> locations = locationService.getLocations(uuid);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        final String json = gson.toJson(locations);
        
        log.debug("<-- getAllLocationsData: " + json);
        return json;
    }
}
