package com.sybit.projektname.controller;

/**
 * Created by fzr on 06.03.17.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sybit.projektname.repository.Location;
import com.sybit.projektname.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class LocationController {
    
    private String location = "Milchwerk";
    private String locatinImg = "https://dl.airtable.com/ddNZDQDSLiyK5Vmkhg76_full_2017-03-03%2021.03.00.jpg";
    @Autowired
    private LocationService locationService;



   @RequestMapping("/location")
    public String welcome(Map<String, Object> model) {
        model.put("locationName",location);
        model.put("locationImg", locatinImg);
        return "location";
    }

    @ResponseBody
    @RequestMapping(value = "location/{slug}.json", method = RequestMethod.GET)
    public String getLocationData(@PathVariable("slug") String locationSlug){

        Location loc = locationService.getLocation(locationSlug);
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(loc);

    }

    @RequestMapping(value = "location/{slug}")
    public String getLocation(@PathVariable("slug") String locationSlug,Map<String, Object> model){

        Location loc = locationService.getLocation(locationSlug);

        model.put("locationName",loc.getName());
        model.put("locationBeschr",loc.getDescription());
        model.put("locationImg", locatinImg);
        return "location";

    }

    @ResponseBody
    @RequestMapping(value = "location/all", method = RequestMethod.GET)
    public String getAllLocationsData(){


        List<Location> locations = locationService.getLocations();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson.toJson(locations);

    }

}