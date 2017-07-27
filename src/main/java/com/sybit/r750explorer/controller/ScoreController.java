package com.sybit.r750explorer.controller;

/**
 * Created by fzr on 06.03.17.
 */
import com.sybit.r750explorer.service.ScoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//Der Score Controller handelt alles was auf der Score Seite passiert.
@Controller
public class ScoreController {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ScoreService scoreService;

    /**
     * Score Page
     ** Hier soll der Score des Users sowie eine Liste mit den besten Highscores angezeigt werden
     *
     * @param uuid Cookie-UUID des Users
     * @param model Daten-Model für die Web-site
     * @return
     */
    @RequestMapping("/myscore")
    public String score(@CookieValue("UUID") String uuid, Map<String, Object> model) {

        log.debug("--> MyScore");
        //Hole dir den Score des Users(UUID)

        //Hole dir alle Highscores

        //Vergiss nicht die Sachen dem Model zu übergeben


        return "myscore";
    }

    /**
     * Registration Page
     ** Der User möchte sich registrieren. Hierfür
     *
     * @param nickname Der Nickname den der user haben möchte
     * @param email Die E-Mail des Users
     * @param uuid Die Cookie UUID des Users
     * @param model Daten Model der Webpage
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam String nickname, @RequestParam String email, @CookieValue("UUID") String uuid, Map<String, Object> model) {

        log.debug("--> Registering... UUID: " + uuid);

        //Der User möchte sich registrieren. Was muss hierfür überprüft werden?
        //Erstelle den Highscore.
        

        model.put("nickname", nickname);

        return "registration";

    }

    /**
     * Der Score auf der Nav-Bar
     ** Damit auf der Navbar immer der aktuelle Score angezeigt wird müssen wir diesen abfragen.
     * @param uuid
     * @return 
     */
    @ResponseBody
    @RequestMapping(value = "/score/{uuid}", method = RequestMethod.GET)
    public String getScore(@PathVariable("uuid") String uuid) {

        log.debug("--> getScore: UUID: " + uuid);

        //Der Score des User mithilfe der UUID abfragen.
        Float score = scoreService.getScoreOfSpielstand(uuid);
        
        log.debug("<-- getScore: " + score);

        return String.valueOf(Math.round(score));
    }

}
