/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.repository;

import com.sybit.r750explorer.repository.tables.Spielstand;
import com.sybit.r750explorer.repository.tables.Highscore;
import com.sybit.airtable.Query;
import com.sybit.airtable.Sort;
import com.sybit.airtable.exception.AirtableException;
import com.sybit.r750explorer.exception.HighscoreCreationException;
import com.sybit.r750explorer.exception.HighscoreSyntaxException;
import com.sybit.r750explorer.exception.SpielstandCreationException;
import com.sybit.r750explorer.exception.SpielstandSyntaxException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.el.MethodNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fzr
 */
@Repository
public class SpielstandRepository extends AirtableRepository {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Creates a new Entry in the Spielstand Table.
     *
     * @param daten
     * @return the created entity
     */
    public Spielstand newEntry(Spielstand daten) {

        log.debug("-->newEntry. Spielstand UUID: " + daten.getUuid());

        Spielstand response;

        try {
            response = (Spielstand) getAirtableBase().table("Spielstand", Spielstand.class).create(daten);
        } catch (AirtableException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            log.error("Error with Airtable: " + e);
            throw new SpielstandCreationException("Error creating Spielstand with UUID: " + daten.getUuid());

        }

        log.debug("<-- newEntry. Retrieved Spielstand from Airtable");
        return response;
    }

    /**
     * Get all entrys in Table Spielstand of specified UUID.
     *
     * @param uuid Cookie-ID of the user
     * @return List of Spielstand
     */
    public List<Spielstand> getEntrysOfUUID(String uuid) {

        log.debug("--> getEntrysOfUUID. UUID: " + uuid);

        Query uuidQuery = getQueryWithFilter("UUID", uuid);
        List<Spielstand> response;

        try {
            response = getAirtableBase().table("Spielstand", Spielstand.class).select(uuidQuery);
        } catch (AirtableException e) {

            log.error("Error with Airtable: " + e);
            throw new SpielstandSyntaxException("Error retrieving entrys of UUID: " + uuid);

        }

        log.debug("<-- getEntrysOfUUID. Retrieved Spielstand List from Airtable");
        return response;
    }

    /**
     * Creates a new Entry in the Highscore Table.
     *
     * @param highscore
     * @return the createt entity
     */
    public Highscore registerScore(Highscore highscore) {

        log.debug("--> registerScore: Highscore UUID: " + highscore.getUuid());

        Highscore response;

        try {
            response = (Highscore) getAirtableBase().table("Highscore", Highscore.class).create(highscore);

        } catch (AirtableException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            log.error("Error with Airtable: " + e);
            throw new HighscoreCreationException("Error creating Highscore of UUID: " + highscore.getUuid());

        }

        log.debug("<--registerScore. Highscore Registered in Airtable.");
        return response;
    }

    /**
     * Get the 15 highest Highscores.
     *
     * @return List of Highscores
     */
    public List<Highscore> getHighscore() {

        log.debug("--> getHighscore.");

        List<Highscore> response;

        Query query = new Query() {
            @Override
            public String[] getFields() {
                return null;
            }

            @Override
            public Integer getPageSize() {
                return null;
            }

            @Override
            public Integer getMaxRecords() {
                return 15;
            }

            @Override
            public String getView() {
                return null;
            }

            @Override
            public List<Sort> getSort() {
                List<Sort> sort = new ArrayList<>();
                sort.add(new Sort("Punkte", Sort.Direction.desc));
                return sort;
            }

            @Override
            public String filterByFormula() {
                return null;
            }
        };

        try {
            response = getAirtableBase().table("Highscore", Highscore.class).select(query);
        } catch (AirtableException e) {
            log.error("Error with Airtable: " + e);
            response = new ArrayList<>();
        }

        log.debug("<-- getHighscore. Retrieved Highscorelist from Airtable.");
        return response;

    }

    /**
     * Get the Highscore of a specified UUID.
     *
     * @param uuid
     * @return Highscore Object
     */
    public List<Highscore> getHighscoreOfUUID(String uuid) {

        log.debug("--> getHighscoreOfUUID. UUID: " + uuid);

        Query uuidquery = getQueryWithFilter("UUID", uuid);
        List<Highscore> response;

        try {
            response = getAirtableBase().table("Highscore", Highscore.class).select(uuidquery);
        } catch (AirtableException e) {
            log.error("Error with Airtable: " + e);
            throw new HighscoreSyntaxException("Error. Could not retrieve Highscore of UUID: " + uuid);
        }

        if (response.isEmpty()) {
            String msg = "No Highscore of UUID: " + uuid + " found.";
            log.warn(msg);
            return null;
        } else {
            log.debug("<-- getHighscoreOfUUID. Retrieved Highscore of UUID: " + uuid);
            return response;
        }

    }

    /**
     * Delete the Highscore of specified UUID.
     *
     * @param uuid
     */
    public void deleteHighscore(String uuid) {

        log.debug("--> deleteHighscore. Highscore UUID: " + uuid);

        String id = getIdOfHighscore(uuid);

        try {
            getAirtableBase().table("Highscore", Highscore.class).destroy(id);
        } catch (AirtableException e) {
            log.error("Error with Airtable: " + e);
            throw new HighscoreSyntaxException("Could not destroy Highscore of UUID: " + uuid);
        }

        log.debug("<-- deleteHighscore. Highscore ID: " + id + " of UUID: " + uuid + " deleted.");

    }

    /**
     * Get the Id of a Highscore specified by its UUID.
     *
     * @param uuid
     * @return String
     */
    public String getIdOfHighscore(String uuid) {

        log.debug("--> getIdOfHighscore. UUID: " + uuid);

        throw new MethodNotFoundException("Methode nicht imnplementiert");
//        log.debug("<-- getIdOfHighscore. Retrieved Highscore");
//
//        return highscore.getId();
    }

}
