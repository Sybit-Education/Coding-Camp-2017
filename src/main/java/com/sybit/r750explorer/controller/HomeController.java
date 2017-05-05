package com.sybit.r750explorer.controller;

/**
 * Created by fzr on 06.03.17.
 */


import com.sybit.airtable.exception.AirtableException;
import com.sybit.projektname.repository.Location;
import com.sybit.projektname.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {



    @Autowired
    private LocationService locationService;
    private String message = "Hello World";

    /**
     * Base Controller
     *
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String welcome(Map<String, Object> model) throws AirtableException {

        List<Location> locations = locationService.getLocations();
        model.put("locations",locations);
        model.put("message", this.message);
        return "home";
    }

}