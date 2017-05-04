package com.sybit.r750explorer.controller;

/**
 * Created by fzr on 06.03.17.
 */

import com.sybit.r750explorer.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class codeproofController {
    
private String location = "Finde den Code der Location Michwerk";
    private String locationImg = "https://dl.airtable.com/ddNZDQDSLiyK5Vmkhg76_full_2017-03-03%2021.03.00.jpg";
    



   @RequestMapping("/codeproof")
    public String codeproof(Map<String, Object> model) {
        model.put("locationName",location);
        model.put("locationImg", locationImg);
        return "codeproof";
    }

}