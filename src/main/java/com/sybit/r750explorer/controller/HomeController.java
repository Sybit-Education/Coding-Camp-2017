package com.sybit.r750explorer.controller;

/**
 * Created by fzr on 06.03.17.
 */


import com.sybit.airtable.exception.AirtableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HomeController {




    private String message = "Hello World";

    /**
     * Base Controller
     *
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String welcome(Map<String, Object> model) throws AirtableException {


        model.put("message", this.message);
        return "welcome";
    }

}