package com.sybit.projektname.controller;

/**
 * Created by fzr on 06.03.17.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class LocationController {
    
    private String location = "Milchwerk";
    private String locatinImg = "resources/Platzhalter-1000x250.png";


    /**
     * Base Controller
     *
     * @param model
     * @return
     */
    @RequestMapping("/location")
    public String welcome(Map<String, Object> model) {
        model.put("locationName",location);
        model.put("locationImg", locatinImg);
        return "location";
    }

}