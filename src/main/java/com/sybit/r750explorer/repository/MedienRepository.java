package com.sybit.r750explorer.repository;

import com.sybit.r750explorer.repository.tables.Medien;
import com.sybit.airtable.Query;
import com.sybit.airtable.Sort;
import com.sybit.airtable.exception.AirtableException;
import com.sybit.r750explorer.exception.MediaNotFoundException;
import com.sybit.r750explorer.exception.MediaSyntaxException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by fzr on 09.05.17.
 */
@Repository
public class MedienRepository extends AirtableRepository {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Get all Medien of a Location by its name.
     *
     * @param name
     * @return List of Medien
     */
    @Cacheable(value = "medienList", key = "#name")
    public List<Medien> getMedienOfLocationName(String name) {

        log.debug("--> getMedienOfLocationName. Name: " + name);

        Query mediaQuery = new Query() {
            @Override
            public String[] getFields() {
                return new String[0];
            }

            @Override
            public Integer getPageSize() {
                return null;
            }

            @Override
            public Integer getMaxRecords() {
                return null;
            }

            @Override
            public String getView() {
                return null;
            }

            @Override
            public List<Sort> getSort() {
                Sort sort = new Sort("Sortierung", Sort.Direction.asc);
                List<Sort> sortList = new ArrayList<>();
                sortList.add(sort);
                return sortList;
            }

            @Override
            public String filterByFormula() {
                String key = "Location";
                String value = name;
                return "({" + key + "} = '" + value + "')";
            }
        };

        List<Medien> medienlist;

        try {
            medienlist = getAirtableBase().table("Medien", Medien.class).select(mediaQuery);
            if (medienlist.isEmpty()) {
                throw new MediaNotFoundException("No Medien found for Location " + name);
            }

        } catch (AirtableException e) {
            log.error("Error with Airtable: " + e);
            throw new MediaSyntaxException("Error. Could not retrieve Medien for Location: " + name);

        }
        log.debug("<-- getMedienOfLocationName. Retrieved Medienlist from Airtable");
        return medienlist;

    }

}
