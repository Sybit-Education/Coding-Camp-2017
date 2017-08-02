package com.sybit.r750explorer.controller;

/**
 * Created by fzr on 06.03.17.
 */
import com.sybit.r750explorer.repository.tables.Location;
import com.sybit.r750explorer.service.LocationService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller for basic handling of home, impressum, datenschutz etc.
 *
 * @author ssr
 */
@Controller
public class HomeController {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Autowired reference of location service.
     */
    @Autowired
    private LocationService locationService;

    
    //HINT Als Beispiel wie Controller funktionieren
    
    /**
     * Controller method to get to Homepage.
     *
     * @param model model of page.
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/")
    public String home(@CookieValue(value = "UUID", required = false) String uuid, Map<String, Object> model, RedirectAttributes redirectAttributes) {

        log.debug("--> Homepage");
        
        List<Location> locations = locationService.getLocations(uuid);
        
        model.put("locations", locations);
      
        return "home";
    }

    /**
     * Controller method to get 'impressum' page.
     *
     * @return
     */
    @RequestMapping("/impressum")
    public String impressum() {

        log.debug("--> Impressum");

        return "impressum";
    }

    /**
     * Controller method to get 'datenschutz' page.
     *
     * @return
     */
    @RequestMapping("/datenschutz")
    public String datenschutz() {

        log.debug("--> Datenschutz");

        return "datenschutz";
    }

    /**
     * Controller method to get 'teilnahme' page.
     *
     * @return
     */
    @RequestMapping("/teilnahme")
    public String teilnahme() {

        log.debug("--> Teilnahmebedingungen");

        return "teilnahme";
    }
    
        /**
     * Controller method to get 'team' page.
     *
     * @return
     */
    @RequestMapping("/team")
    public String team() {

        log.debug("--> Team");

        return "team";
    }
}
