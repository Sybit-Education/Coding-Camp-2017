package com.sybit.r750explorer.service;

import com.sybit.r750explorer.repository.tables.Highscore;
import com.sybit.r750explorer.repository.tables.Location;
import com.sybit.r750explorer.repository.LocationRepository;
import com.sybit.r750explorer.repository.tables.Spielstand;
import com.sybit.r750explorer.repository.SpielstandRepository;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Created by fzr on 11.05.17.
 */
//HINT Hier könnte man alle Methoden als aufgabe verwenden --> Tests etwas schwieriger
@Service
public class ScoreService {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SpielstandRepository spielstandRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    LocationService locationService;

    /**
     * Creates a Spielstand Object and writes it into the Spielstand Table. *
     * Methode die den Spielstand baut und an das Repository übergibt damit es
     * in die DB * gechrieben wird
     *
     * @param uuid Die Cookie-UUID des Users
     * @param loc Die Location
     * @param questionId Die ID der Frage
     * @param answerIndx Der Index der Antwort
     * @param score Welchen score bekommt er hierfür
     * @return the created Spielstand
     */
    public Spielstand newSpielstandEntry(String uuid, Location loc, String questionId, String answerIndx, Float score) {

        log.debug("--> newSpielstandEntry. UUID: " + uuid);

        //Erstelle einen neuen Spielstand und befülle ihn mit den entsprechenden Werten
        Spielstand spielstand = new Spielstand();
        spielstand.setUuid(uuid);

        List<String> location = new ArrayList<>();
        if (loc != null) {
            location.add(loc.getId());
        }
        List<String> fragen = new ArrayList<>();
        if (questionId != null) {
            fragen.add(questionId);
        }
        spielstand.setLocationList(location);
        spielstand.setQuestionList(fragen);
        spielstand.setUserAnswerIndex(answerIndx);
        spielstand.setScore(String.valueOf(score));
        spielstand.setQuestionList(fragen);

        //Dann übergib ihn an das Repository
        spielstand = spielstandRepository.newEntry(spielstand);

        log.debug("<-- newSpielstandEntry");
        return spielstand;

    }

    /**
     * Get the total Score of a UUID. * Diese Methode rechnet alle Scores für
     * einen bestimmten Spielstand zusammen.
     *
     * @param uuid
     * @return Float score
     */
    public Float getScoreOfSpielstand(String uuid) {

        log.debug("--> getScoreOfSpielstand. UUID: " + uuid);

        //Hole dir die Spielstände und rechne sie zusammen
        List<Spielstand> spielstand = spielstandRepository.getEntrysOfUUID(uuid);
        Float score = Float.valueOf(0);
        for (Spielstand i : spielstand) {
            score += Float.valueOf(i.getScore());
        }

        log.debug("<-- getScoreOfSpielstand");
        return score;

    }

    /**
     * Get the Highscore List. Holt dir die Highscoreliste
     *
     * @return List of Higscores
     */
    public List<Highscore> getHighscoreList() {

        log.debug("--> getHighscoreList");
        return spielstandRepository.getHighscore();

    }

    /**
     * Get the Highscore List. Holt dir die Highscoreliste des aktuellen Monats
     *
     * @return List of Higscores
     */
    public List<Highscore> getHighscoreListForMonth() {
        log.debug("--> getHighscoreListForMonth");

        List<Highscore> currentMonth = new ArrayList<>();
        List<Highscore> listMonth = spielstandRepository.getHighscore();
        LocalDateTime currentdate = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ISO_LOCAL_DATE;
        String formatdate = currentdate.format(df);
        formatdate = formatdate.substring(0, 7);

        for (Highscore hs : listMonth) {
            String date = hs.getDate();
            date = date.substring(0, 7);

            if (date.equalsIgnoreCase(formatdate)) {
                currentMonth.add(hs);
            }

        }

        log.debug("<-- getHighscoreListForMonth");
        return currentMonth;
    }

    /**
     * Iterates over all highscores of a specified UUID. Returns false if there
     * is none or if the Month isnt equal to the current month
     *
     * @param uuid
     * @return boolean
     */
    public boolean checkIfPlayerExists(String uuid) {
        log.debug("--> checkIfPlayerExists. UUID: " + uuid);
        //wenn UUID bereits einen Highscore eingetragen hat, false übergeben werden
        // Datum überprüfen

        LocalDateTime currentdate = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ISO_LOCAL_DATE;
        String formatdate = currentdate.format(df);
        formatdate = formatdate.substring(0, 7);

        for (Highscore hs : spielstandRepository.getHighscoreOfUUID(uuid)) {
            String date = hs.getDate();
            date = date.substring(0, 7);

            if (date.equalsIgnoreCase(formatdate)) {
                log.debug("<-- checkIfPlayerExists");
                return true;
            }
        }

        log.debug("<-- checkIfPlayerExists");
        return false;
    }

    /**
     * Creates a new Highscore and writes it in the Highscore Table.
     *
     * @param vorname
     * @param nachname
     * @param nickname
     * @param email
     * @param uuid
     * @return the created Highscore
     */
    public Highscore newHighscore(String vorname, String nachname, String nickname, String email, String uuid) {
        log.debug("--> newHighscore. UUID: " + uuid);

        Highscore highScore = new Highscore();
        highScore.setVorname(vorname);
        highScore.setNachname(nachname);
        highScore.setNickname(nickname);
        highScore.setEmail(email);
        highScore.setUuid(uuid);
        highScore.setScore(getScoreOfSpielstand(uuid));

        Highscore result = null;

        if (!checkIfPlayerExists(uuid)) {
            log.info("Neuer Highscore angelegt! UUID: " + uuid);
            result = spielstandRepository.registerScore(highScore);
        } else {
            log.info("Highscore aktualisiert! UUID: " + uuid);
            removeHighscore(uuid);
            spielstandRepository.registerScore(highScore);
            result = null;
        }

        log.debug("<-- newHighscore");
        return result;

    }

    /**
     * Removes a Highscore from the Highscore Table.
     *
     * @param uuid
     */
    public void removeHighscore(String uuid) {

        log.debug("--> removeHighscore. UUID: " + uuid);
        spielstandRepository.deleteHighscore(uuid);
    }

    public Float hintRequested(String uuid) {

        //Hole aktuellen Spielstand aus Airtable als Float
        Float score = this.getScoreOfSpielstand(uuid);
        if (score >= Float.valueOf(5)) {
            score = Float.valueOf(-5);
        } else if (Objects.equals(score, Float.valueOf(0))) {
            score = Float.valueOf(0);
        } else {
            score = Float.valueOf(-score);
        }
        return score;
    }

    public int getRang(String uuid) {
        Float spielstand = getScoreOfSpielstand(uuid);        
        int rang=0;
        if (spielstand<=22){
            rang=0;
        } else if (spielstand<=70){
            rang=1;            
        } else if (spielstand<=120){
            rang=2;            
        } else {
            rang=3;            
        }
        return rang;
    }

}
