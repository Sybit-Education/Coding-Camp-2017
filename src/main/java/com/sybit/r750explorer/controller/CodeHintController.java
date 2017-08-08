package com.sybit.r750explorer.controller;

import com.sybit.r750explorer.repository.tables.Location;
import com.sybit.r750explorer.service.LocationService;
import com.sybit.r750explorer.service.ScoreService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for the Code Hints.
 *
 */
@Controller
@RequestMapping("/location/{slug}")
public class CodeHintController {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LocationService locationService;

    @Autowired
    private ScoreService scoreService;

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
    public String codeHint(@CookieValue("UUID") String scoreCookie, @PathVariable("slug") String slug, HttpServletRequest request, Map<String, Object> model) {

        log.debug("--> CodeHint");

        Location location = locationService.getLocation(slug);
        log.info("Hinweis für LocationSlug: " + location.getName() + " wurde aufgerufen!");

        //Neuer Spielstand mit -5 Punkten wird angelegt
        HttpSession session = request.getSession();
        if (session != null) {
            if (session.getAttribute("Location_Hint_" + slug) == null) {
                session.setAttribute("Location_Hint_" + slug, true);
                scoreService.newSpielstandEntry(scoreCookie, null, null, "Hinweis", scoreService.hintRequested(scoreCookie));
            }
        }
        model.put("locationSlug", slug);
        model.put("code", location.getCode());
        model.put("locationName", location.getName());
        model.put("hint", location.getCodeHinweis());
        model.put("Hinfoto", location.getCodeHintPhoto());
        model.put("HinText", location.getCodeHinweis());

        return "code-hint";
    }

}
