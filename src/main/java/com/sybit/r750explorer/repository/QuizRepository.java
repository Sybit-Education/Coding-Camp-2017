package com.sybit.r750explorer.repository;

import com.sybit.r750explorer.repository.tables.Fragen;
import com.sybit.airtable.Query;
import com.sybit.airtable.exception.AirtableException;
import com.sybit.r750explorer.exception.FrageException;
import com.sybit.r750explorer.exception.FrageNotFoundException;
import com.sybit.r750explorer.exception.FrageSyntaxException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yms on 12.05.2017.
 */
@Repository
public class QuizRepository extends AirtableRepository {

    @Autowired
    private LocationRepository locationRepository;

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Get a List of Fragen for a Location specified by the Slug.
     *
     * @param slug
     * @return List of Fragen
     */
    public List<Fragen> getFragenOfLocation(String slug) {

        log.debug("--> getFragenOfLocation. Slug: " + slug);

        Query slugQuery = getQueryWithFilter("Location", locationRepository.getLocationNameOfSlug(slug));
        List<Fragen> fragenList;

        try {
            fragenList = getAirtableBase().table("Fragen", Fragen.class).select(slugQuery);
            if (fragenList.isEmpty()) {
                throw new FrageNotFoundException("No Fragen found for Location Slug:" + slug);
            }

        } catch (AirtableException e) {
            log.error("Error with Airtable: " + e);
            throw new FrageSyntaxException("Error retrieving Fragen Location Slug: " + slug);

        }

        log.debug("<-- getFragenOfLocation. Retrieved Fragen of Location. slug: " + slug);
        return fragenList;
    }

    /**
     * Get a single Frage specified by its id.
     *
     * @param id
     * @return Fragen Object
     */
    public Fragen getFrageOfId(String id) {

        log.debug("--> getFrageOfId. Id: " + id);

        Fragen frage = null;

        try {
            frage = (Fragen) getAirtableBase().table("Fragen", Fragen.class).find(id);

        } catch (AirtableException e) {
            log.error("Error with Airtable: " + e);
            throw new FrageSyntaxException("Error with Frage Id: " + id);
        }

        log.debug("<-- getFrageOfId. Retrieved Frage. Id " + id);
        return frage;

    }
}
