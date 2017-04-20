package com.sybit.projektname.controller;

/**
 * Created by fzr on 06.03.17.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HomeController {


    /**
     * Base Controller
     *
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        return "welcome";
    }

}