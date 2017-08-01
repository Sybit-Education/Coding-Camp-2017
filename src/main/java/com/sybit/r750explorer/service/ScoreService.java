package com.sybit.r750explorer.service;

import com.sybit.r750explorer.repository.tables.Highscore;
import com.sybit.r750explorer.repository.tables.Location;
import com.sybit.r750explorer.repository.LocationRepository;
import com.sybit.r750explorer.repository.tables.Spielstand;
import com.sybit.r750explorer.repository.SpielstandRepository;
import java.util.List;
import javax.el.MethodNotFoundException;
import javax.swing.text.html.parser.DTDConstants;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        //Dann übergib ihn an das Repository
        return new Spielstand();

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
        log.error("Methode nicht implementiert");
        return Float.valueOf(0);

    }

    /**
     * Get the Highscore List. 
     * Holt dir die Highscoreliste
     *
     * @return List of Higscores
     */
    public List<Highscore> getHighscoreList() {

        log.debug("--> getHighscoreList");
        throw new MethodNotFoundException("Methode nicht implementiert");

    }

    /**
     * Format the Highscore List. Date gets shorter. * Damit die Highscoreliste
     * schöner aussieht
     *
     * @param list
     * @return formatted Highscore List
     */
    public List<Highscore> formatHighscoreList(List<Highscore> list) {

        log.debug("--> formatHighscoreList");
        //Formatiere die Liste
        throw new MethodNotFoundException("Methode nicht implementiert");
    }

    /**
     * Checks if a player already registered a Highscore. 
     * Methode die Nachschaut ob ein Spieler existiert
     *
     * @param uuid
     * @return boolean
     */
    public boolean checkIfPlayerExists(String uuid) {

        log.debug("--> checkIfPlayerExists. UUID: " + uuid);
        //wenn UUID bereits einen Highscore eingetragen hat, false übergeben werden
        throw new MethodNotFoundException("Methode nicht implementiert");

    }

    /**
     * Creates a new Highscore and writes it in the Highscore Table.
     *
     * @param nickname
     * @param email
     * @param uuid
     * @return the created Highscore
     */
    public Highscore newHighscore( String nickname, String email, String uuid )
    {
        log.debug( "--> newHighscore. UUID: " + uuid );

        Highscore highScore = new Highscore(  );
        highScore.setNickname( nickname );
        highScore.setEmail( email );
        highScore.setUuid( uuid );
        //highScore.setDate( date ); Wird automatisch erzeugt
        highScore.setScore( getScoreOfSpielstand( uuid ) );
        
        if ( spielstandRepository.getHighscoreOfUUID( uuid ) == null )
        {
            spielstandRepository.registerScore( highScore );
        }
        else
        {
            
        }
        
        //Informationen zum Abspeichern des Highscores
        //Den Score registrieren
        throw new MethodNotFoundException("Methode nicht implementiert");
    }

    /**
     * Removes a Highscore from the Highscore Table.
     *
     * @param uuid
     */
    public void removeHighscore(String uuid) {

        log.debug("--> removeHighscore. UUID: " + uuid);

        //Spielstand Löschen über spielstandRepository
        throw new MethodNotFoundException("Methode nicht implementiert");

    } ////////////////////////////// TTTTTTTOOOOOOOOOOOOOODDDDDDDDDDDDDDOOOOOOOOOOOOOOOOOOOO: Außeinandersetzung mit Flo/Erik

    public Float hintRequested(String uuid) {

        //Hole aktuellen Spielstand aus Airtable als Float
        //Wenn Score größergleich 50, soll ein neuer Score mit einem Wert von -50 übergeben werden
        //andernfalls 0
        throw new MethodNotFoundException("Methode nicht implementiert");

    }

}
