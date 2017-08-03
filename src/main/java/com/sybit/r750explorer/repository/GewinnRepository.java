/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.repository;

import com.sybit.airtable.Query;
import com.sybit.airtable.exception.AirtableException;
import com.sybit.r750explorer.exception.SpielstandSyntaxException;
import com.sybit.r750explorer.repository.tables.Gewinn;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Schüler
 */
@Repository
public class GewinnRepository extends AirtableRepository {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    public List<Gewinn> getAll() {

        log.debug("--> getAll");

        Query gewinnQuery = getQueryWithFilter("Status", "aktiv");
        List<Gewinn> response;

        try {
            response = getAirtableBase().table("Gewinne", Gewinn.class).select(gewinnQuery);
        } catch (AirtableException e) {

            log.error("Error with Airtable: " + e);
            throw new SpielstandSyntaxException("Error retrieving entrys of Gewinne");

        }

        log.debug("<-- getAll");
        return response;
    }

}
