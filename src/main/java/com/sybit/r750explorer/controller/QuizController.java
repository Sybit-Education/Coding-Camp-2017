package com.sybit.r750explorer.controller;

/**
 * Created by fzr on 06.03.17.
 */
import com.sybit.r750explorer.exception.FrageException;
import com.sybit.r750explorer.exception.FrageNotFoundException;
import com.sybit.r750explorer.exception.MailException;
import com.sybit.r750explorer.repository.tables.Fragen;
import com.sybit.r750explorer.repository.tables.Location;
import com.sybit.r750explorer.service.LocationService;
import com.sybit.r750explorer.service.MailService;
import com.sybit.r750explorer.service.QuizService;
import com.sybit.r750explorer.service.ScoreService;
import java.io.Serializable;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/location/{slug}")
public class QuizController implements Serializable {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LocationService locationService;

    @Autowired
    private QuizService quizService;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private MailService mailService;

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
    @RequestMapping(value = "/code")
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

    @RequestMapping(value = "/quiz")
    public String quiz(@CookieValue("UUID") String uuid, HttpServletRequest request, @RequestParam boolean mail, @RequestParam String code, @PathVariable("slug") String slug, Map<String, Object> model, RedirectAttributes attributes) {

        log.debug("--> CodePage");

        if (!(boolean) model.get("check")) {
            attributes.addFlashAttribute("message", "Sie wurden auf die Homeseite umgeleitet!");
            return "redirect:" + "/";
        }

        Location loc = locationService.getLocation(slug);

        HttpSession session = request.getSession();
        Fragen frage = null;
        if (code.equalsIgnoreCase(locationService.getLocation(slug).getCode())) {

            if (mail && session.getAttribute("Location_Hint_report_" + slug) == null) {
                try {
                    mailService.sendMessage(loc.getName() + ": " + "Code ist nicht auffindbar/lesbar. Bitte umgehend neu anbringen!", uuid);
                } catch (MailException ex) {
                    log.error(ex.getMessage(), ex);
                }
                session.setAttribute("Location_Hint_report_" + slug, true);
                scoreService.newSpielstandEntry(uuid, null, null, "Hinweis", Float.valueOf(5));
            }

            model.put("frage", questionInSession(slug, request));
            model.put("location", locationService.getLocation(slug));
            model.put("codeCheck", true);

            return "quiz";

        } else {
            model.put("location", locationService.getLocation(slug));
            model.put("codeCheck", false);
            if (codeEntryCounter(slug, request, uuid)) {
                model.put("maxEntries", true);
            }
            return "codeproof";
        }
    }

    /**
     * Code counter
     *
     * Method to count entered code of location
     *
     * @param slug URL-Part of Location
     * @param request
     * @return
     */
    private boolean codeEntryCounter(String slug, HttpServletRequest request, String uuid) {

        log.debug("--> codeEntryCounter");

        boolean entriesFull = false;
        HttpSession session = request.getSession();

        if (session != null) {
            if (session.getAttribute("Location_" + slug) != null) {
                String value = session.getAttribute("Location_" + slug).toString();
                Integer counter = Integer.valueOf(value);
                log.debug("LocationCode: " + locationService.getLocation(slug).getCode() + ". Entries: " + counter);
                counter++;
                log.debug(counter + " Mal falsch eingegeben");

                if (counter >= 10) {
                    log.info("Code Eingabe gesperrt! UUID: " + uuid);
                    entriesFull = true;
                }
                session.setAttribute("Location_" + slug, counter);

            } else {
                session.setAttribute("Location_" + slug, "0");
            }
        }
        return entriesFull;
    }

    public Fragen questionInSession(String slug, HttpServletRequest request) {

        HttpSession session = request.getSession();

        Fragen frage;
        try {
            frage = quizService.getFrageOfLocation(slug);
            if (session.getAttribute("Location_Quiz_" + slug) != null) {
                frage = quizService.getFrageOfID(session.getAttribute("Location_Quiz_" + slug).toString());
            } else {
                session.setAttribute("Location_Quiz_" + slug, frage.getId());
            }
        } catch (FrageException e) {
            frage = null;
            log.error(e.getMessage());
            throw new FrageNotFoundException("Keine Frage zu LocationSlug: " + slug + "gefunden!");
        }

        return frage;
    }

    /**
     * Quiz check
     *
     * Method to compare the selected answer with the correct answer of current
     * question
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

        Fragen frage = quizService.getFrageOfID(fragenID);
        Float score;
        if (frage.getLoesung().equals(Float.valueOf(antwort))) {
            model.put("loesung", true);
            score = Float.valueOf(10);
        } else {
            model.put("loesung", false);
            score = Float.valueOf(1);
        }

        scoreService.newSpielstandEntry(scoreCookie, locationService.getLocation(slug), fragenID, antwort, score);

        model.put("loesungText", frage.getLoesungText());
        model.put("location", locationService.getLocation(slug));

        return "quiz-check";
    }

}
