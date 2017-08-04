/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.repository;

import com.sybit.airtable.Query;
import com.sybit.airtable.Sort;
import com.sybit.airtable.exception.AirtableException;
import com.sybit.r750explorer.exception.SponsorenNotFoundException;
import com.sybit.r750explorer.exception.SponsorenSyntaxException;
import com.sybit.r750explorer.repository.tables.Sponsor;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fzr
 */
@Repository
public class SponsorenRepository extends AirtableRepository {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    public List<Sponsor> getSponsoren() {

        log.debug("--> getSponsoren");

        List<Sponsor> sponsorenList = new ArrayList<>();
        final Query activeQuery = new Query() {
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
                return null;
            }

            @Override
            public String getView() {
                return null;
            }

            @Override
            public List<Sort> getSort() {
                List<Sort> sort = new ArrayList<>();
                sort.add(new Sort("Name", Sort.Direction.asc));
                return sort;
            }

            @Override
            public String filterByFormula() {
                return "({Status} = 'aktiv')";
            }
        };

        try {
            sponsorenList = getAirtableBase().table("Sponsoren", Sponsor.class).select(activeQuery);
            if (sponsorenList.isEmpty()) {
                throw new SponsorenNotFoundException("No Sponsoren found!");
            }
        } catch (AirtableException e) {
            log.error(e.getMessage(), e);

            throw new SponsorenSyntaxException("Error. Could not retrieve Sponsoren!");

        }

        log.debug("<-- getSponsoren()");
        return sponsorenList;
    }

}
