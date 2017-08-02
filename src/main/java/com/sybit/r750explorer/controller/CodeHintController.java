/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.controller;

import com.sybit.r750explorer.exception.MailException;
import com.sybit.r750explorer.repository.tables.Location;
import com.sybit.r750explorer.service.LocationService;
import com.sybit.r750explorer.service.MailService;
import com.sybit.r750explorer.service.ScoreService;
import java.util.Map;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for the Code Hints.
 * 
 */
@Controller
@RequestMapping("/location/{slug}")
public class CodeHintController {
        
    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LocationService locationService;
    
    @Autowired
    private MailService mailService;
    
    @Autowired
    private ScoreService scoreService;
    
    /**
     * Send a message for given location if code is missing or damaged.
     * 
     * @param uuid Cookie-ID of the user.
     * @param locationSlug url of the location.
     * @param message Message of the user.
     * @param model Model to add data on web page.
     * 
     * @return "code-hint". 
     */
    @RequestMapping(value = "/code/hint/message")
    public String sendMessage(@CookieValue("UUID") String uuid, @PathVariable("slug") String locationSlug, Map<String, Object> model) {

        log.debug("--> sendMessage: Location Slug: " + locationSlug + ". UUID: " + uuid);
        log.info("Message: " + "Code ist nicht auffindbar/lesbar. Bitte umgehend neu anbringen!");

        Location location = locationService.getLocation(locationSlug);
        try {
            mailService.sendMessage(location.getName() + ": " + "Code ist nicht auffindbar/lesbar. Bitte umgehend neu anbringen!", uuid);
        } catch (MailException ex) {
            log.error(ex.toString());
        }
        
        scoreService.newSpielstandEntry(uuid, location, uuid, uuid, Float.valueOf(5));
        
        model.put("locationSlug", locationSlug);
        model.put("code", location.getCode());
        model.put("locationName", location.getName());
        model.put("hint", location.getCodeHinweis());    

        return "code-hint";
    } 
    
      /**
     * Code Hint Page
     *
     * Method to reduce current score of user for using a hint
     *
     * @param scoreCookie Cookie-ID of the user
     * @param slug URL-Part of Location
     * @param model Model to add data to web page
     * @return
     */
    @RequestMapping(value = "/code/hint")
    public String codeHint(@CookieValue("UUID") String scoreCookie, @PathVariable("slug") String slug, Map<String, Object> model) {

        log.debug("--> CodeHint");

        Location location = locationService.getLocation(slug);
        log.info("Hinweis für LocationSlug: " + location.getName() + " wurde aufgerufen!");
        scoreService.newSpielstandEntry(scoreCookie, null, null, "Hinweis", scoreService.hintRequested(scoreCookie));

        // TODO: Einen neuen Spielstand speichern (Punkte abziehen) und Informationen an model übergeben
        
        model.put("locationSlug",slug );
        model.put("code", location.getCode());
        model.put("locationName", location.getName());
        model.put("hint", location.getCodeHinweis());
        model.put("Hinfoto", location.getCodeHintPhoto());
        model.put("HinText", location.getCodeHinweis());
       
        return "code-hint";
    }

}
