package com.sybit.r750explorer.controller;

/**
 * Created by fzr on 06.03.17.
 */
import com.sybit.r750explorer.repository.tables.Fragen;
import com.sybit.r750explorer.repository.tables.Location;
import com.sybit.r750explorer.service.LocationService;
import com.sybit.r750explorer.service.QuizService;
import com.sybit.r750explorer.service.ScoreService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/location/{slug}")
public class QuizController {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LocationService locationService;

    @Autowired
    private QuizService quizService;

    @Autowired
    private ScoreService scoreService;

    @ModelAttribute("check")
    public boolean checkLocation(@CookieValue("UUID") String uuid, @PathVariable("slug") String slug) {

        log.debug("--> checkLocation");

        Location loc = locationService.getLocation(slug);
        List<Location> visited = locationService.getVisitedLocations(uuid);

        for (Location l : visited) {
            if (l.getName().equals(loc.getName())) {
                return false;
            }
        }

        return true;
    }

    /**
     * Code Entry Page
     *
     * Method to show code entry page
     *
     * @param slug URL-Part of Location
     * @param model Model to add data to web page
     * @param attributes
     * @return
     */
    @RequestMapping(value="/code")
    public String code(@PathVariable("slug") String slug, Map<String, Object> model, RedirectAttributes attributes) {

        log.debug("--> CodePage");

        if (!(boolean) model.get("check")) {
            attributes.addFlashAttribute("message", "Sie wurden auf die Homeseite umgeleitet!");
            return "redirect:" + "/";
        }

        Location loc = locationService.getLocation(slug);

        model.put("location", loc);

        return "codeproof";
    }
    
    /**
     * Code check
     *
     * Method to compare entered code with the original of location
     *
     * @param code Entered code
     * @param slug URL-Part of Location
     * @param model Model to add data to web page
     * @param attributes
     * @return
     */
    @RequestMapping(value = "/code/check", method = RequestMethod.POST)
    public String checkCode(@RequestParam String code, @PathVariable("slug") String slug, Map<String, Object> model, RedirectAttributes attributes) {

        log.debug("--> CodeCheck. UserCode: " + code + ". LocationCode: " + locationService.getLocation(slug).getCode());

        if (!(boolean) model.get("check")) {
            attributes.addFlashAttribute("message", "Sie wurden auf die Homeseite umgeleitet!");
            return "redirect:" + "/";
        }

        // TODO: Die Frage der Location anhand des Slugs holen und im Fehlerfall auf die Homepage umleiten
        Fragen frage=null;
        try{
            frage=quizService.getFrageOfLocation(slug);
        }
        catch(Exception e){
            attributes.addFlashAttribute("message", "Sie wurden auf die Homeseite umgeleitet!");
            return "redirect:" + "/";
        }
        
        // TODO: Wenn der eigegebene Code übereinstimmt und die Frage vorhanden ist - an model übergeben
        if (code.equals(locationService.getLocation(slug).getCode())){
            model.put("location", locationService.getLocation(slug));
            model.put("frage", frage);
            return "quiz";
        }
        else{
            model.put("codeCheck", false);
            log.debug("Code war nicht korrekt!");

        return "codeproof";
        }
    }
   

    @RequestMapping(value="/quiz")
    public String quiz(@PathVariable("slug") String slug, Map<String, Object> model, RedirectAttributes attributes) {

        log.debug("--> CodePage");

        if (!(boolean) model.get("check")) {
            attributes.addFlashAttribute("message", "Sie wurden auf die Homeseite umgeleitet!");
            return "redirect:" + "/";
    }
    

        Location loc = locationService.getLocation(slug);
        
        Fragen frage=null;
        try{
            frage=quizService.getFrageOfLocation(slug);
        }
        catch(Exception e){
            attributes.addFlashAttribute("message", "Sie wurden auf die Homeseite umgeleitet!");
            return "redirect:" + "/";
        }
        
        model.put("location", loc);
        model.put("frage", frage);

        return "quiz";
    }
        
    /**
     * Quiz check
     *
     * Method to compare the selected answer with the correct answer of current question
     *
     * @param scoreCookie Cookie-ID of the user
     * @param antwort Entered answer
     * @param fragenID Current question
     * @param slug URL-Part of Location
     * @param model Model to add data to web page
     * @param attributes
     * @return
     */
    @RequestMapping(value = "/quiz/check", method = RequestMethod.POST)
    public String checkQuiz(@CookieValue("UUID") String scoreCookie, @RequestParam String antwort, @RequestParam String fragenID, @PathVariable("slug") String slug, Map<String, Object> model, RedirectAttributes attributes) {

        log.debug("--> QuizCheck");

        if (!(boolean) model.get("check")) {
            attributes.addFlashAttribute("message", "Sie wurden auf die Homeseite umgeleitet!");
            return "redirect:" + "/";
        }

        // TODO: Prüfen, ob die originale Lösung mit der eingegebenen Lösung übereinstimmt, Punkte vergeben und eine Rückmeldung an model übergeben

        //scoreService.newSpielstandEntry(scoreCookie, locationService.getLocation(slug), fragenID, antwort, score);
        model.put("location", locationService.getLocation(slug));

        return "quiz-check";
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

        // TODO: Einen neuen Spielstand speichern (Punkte abziehen) und Informationen an model übergeben

        return "code-hint";
    }

}
