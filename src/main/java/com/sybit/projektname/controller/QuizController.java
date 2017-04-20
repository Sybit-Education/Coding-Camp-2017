package com.sybit.projektname.controller;

/**
 * Created by fzr on 06.03.17.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class QuizController {
    
    private String quiz= "Fragen zu Milchwerk";
    private String locationImg = "https://dl.airtable.com/ddNZDQDSLiyK5Vmkhg76_full_2017-03-03%2021.03.00.jpg";


    /**
     * Base Controller
     *
     * @param model
     * @return
     */
    @RequestMapping("/quiz")
    public String welcome(Map<String, Object> model) {
        model.put("quizName",quiz);
        model.put("locationImg", locationImg);
        return "quiz";
    }

}