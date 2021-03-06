package com.sybit.r750explorer.controller;

/**
 * Created by fzr on 06.03.17.
 */
import com.sybit.r750explorer.repository.tables.Highscore;
import com.sybit.r750explorer.service.ScoreService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//Der Score Controller handelt alles was auf der Score Seite passiert.
@Controller
public class ScoreController {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    // Regular Expression für eMail Validation
    private static final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static final String NICKNAME_PATTERN
            = "^[A-Za-z0-9-]{4,16}$";

    @Autowired
    ScoreService scoreService;

    @Autowired
    private ApplicationContext appContext;

    /**
     * Score Page * Hier soll der Score des Users sowie eine Liste mit den
     * besten Highscores angezeigt werden
     *
     * @param uuid Cookie-UUID des Users
     * @param model Daten-Model für die Web-site
     * @return
     */
    @RequestMapping("/myscore")
    public String score(@CookieValue(name = "UUID", required = false) String uuid, Map<String, Object> model) {

        log.debug("--> MyScore");

        int badge = scoreService.getRang(uuid);

        Float s = scoreService.getScoreOfSpielstand(uuid);
        List<Highscore> lScore = scoreService.getHighscoreListForMonth();

        model.put("Badge", badge);
        model.put("Punkte", s);
        model.put("Liste", lScore);

        return "myscore";
    }

    /**
     * Registration Page * Der User möchte sich registrieren. Hierfür
     *
     * @param vorname
     * @param nachname
     * @param nickname Der Nickname den der user haben möchte
     * @param email Die E-Mail des Users
     * @param uuid Die Cookie UUID des Users
     * @param model Daten Model der Webpage
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam String vorname, @RequestParam String nachname, @RequestParam String nickname, @RequestParam String email, @CookieValue(name = "UUID") String uuid, Map<String, Object> model) {

        log.debug("--> Registering... UUID: " + uuid);

        int badge = scoreService.getRang(uuid);
        Float s = scoreService.getScoreOfSpielstand(uuid);
        List<Highscore> lScore = scoreService.getHighscoreListForMonth();

        model.put("Badge", badge);
        model.put("Punkte", s);
        model.put("Liste", lScore);

        // Überprüfung des Namens 
        Pattern pattern = Pattern.compile(NICKNAME_PATTERN);
        Matcher matcher = pattern.matcher(nickname);
        if (!matcher.matches()) {
            model.put("message", "Bitte wähle einen Nickname von einer Länge zwischen 4 und 16 Zeichen. Sonderzeichen sind nicht erlaubt.");
            return "myscore";
        }

        // Überprüfung der EMail
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);

        if (matcher.matches()) {
            log.debug("<-- register(): EMail ist im richtigen Format");
            model.put("nickname", nickname);
        } else {
            log.debug("<-- register(): EMail ist nicht im richtigen Format");
            model.put("message", "<b>Fehler: Deine eMail-Addresse ist nicht richtig.</b>");
            return "myscore";
        }

        //Der User möchte sich registrieren. Was muss hierfür überprüft werden?
        //Erstelle den Highscore.
        Highscore hs = scoreService.newHighscore(vorname, nachname, nickname, email, uuid);
        if (hs != null) {
            model.put("message", "Du hast dich registriert.");
        } else {
            model.put("message", "<b>Du hast deinen Score aktualisiert.</b>");

        }

        return "myscore";
    }

    /**
     * Der Score auf der Nav-Bar * Damit auf der Navbar immer der aktuelle Score
     * angezeigt wird müssen wir diesen abfragen.
     *
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

    @ResponseBody
    @RequestMapping(value = "/score/badge/{uuid}", method = RequestMethod.GET)
    public String getBadge(@PathVariable("uuid") String uuid) {

        log.debug("--> getBadge");

        //Der Score des User mithilfe der UUID abfragen.
        int rang = scoreService.getRang(uuid);
        String returnvalue;
        switch (rang) {
            case 3:
                returnvalue = "gold128x128.png";
                break;
            case 2:
                returnvalue = "silber128x128.png";
                break;
            case 1:
                returnvalue = "bronze128x128.png";
                break;
            default:
                returnvalue = "empty128x128.png";
                break;
        }

        log.debug("<-- getBadge");

        return returnvalue;
    }

}
