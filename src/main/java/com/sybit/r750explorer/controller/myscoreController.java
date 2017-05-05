package com.sybit.r750explorer.controller;

/**
 * Created by fzr on 06.03.17.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class myscoreController {
    


    /**
     * Base Controller
     *
     * @param model
     * @return
     */
    @RequestMapping("/myscore")
    public String welcome(Map<String, Object> model) {
        return "myscore";
    }

}