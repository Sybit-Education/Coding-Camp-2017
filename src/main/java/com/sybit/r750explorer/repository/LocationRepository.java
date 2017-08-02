package com.sybit.r750explorer.repository;

import com.sybit.r750explorer.exception.LocationException;
import com.sybit.r750explorer.repository.tables.Location;
import com.sybit.airtable.Query;
import com.sybit.airtable.Sort;

import com.sybit.airtable.exception.AirtableException;

import com.sybit.r750explorer.exception.LocationNotFoundException;
import com.sybit.r750explorer.exception.LocationSyntaxException;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by fzr on 11.04.17.
 */
@Repository
public class LocationRepository extends AirtableRepository {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Get all Locations from Airtable.
     *
     * @return List of Locations
     */
    @Cacheable(value = "locationsList")
    public List<Location> getLocationList() {

        log.debug("--> getLocationList");

        Query activeQuery = getQueryWithFilter("Status", "aktiv");
        List<Location> locationList;

        try {

            locationList = getAirtableBase().table("Location", Location.class).select(activeQuery);
        } catch (AirtableException e) {
            log.error(e.getMessage(), e);
            throw new LocationSyntaxException("Error could not retrieve LocationList");
        }

        log.debug("<-- getLocationList. size: " + locationList.size());
        return locationList;
    }

    /**
     * Get a single Location from airtable specified by id.
     *
     * @param id Location id in the airtable
     * @return single Location
     */
    @Cacheable(value = "location", key = "#id")
    public Location getLocation(String id) {

        log.debug("--> getLocation. ID: " + id);

        Location location;
        try {
            location = (Location) getAirtableBase().table("Location", Location.class).find(id);
        } catch (AirtableException e) {
            log.error(e.getMessage(), e);
            throw new LocationSyntaxException("Error could not Retrieve Location of ID:" + id);
        }

        log.debug("<-- getLocation. Retrieved Location from Airtable");
        return location;

    }

    /**
     * Get a single Location from airtable specified by the slug.
     *
     * @param slug
     * @return single Location
     */

    @Cacheable(value = "location", key = "#slug")
    public Location getLocationOfSlug(String slug) {

        log.debug("--> getLocationOfSlug. Slug: " + slug);

        Query slugQuery = new Query() {
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
                return null;
            }

            @Override
            public String filterByFormula() {
                return "AND({" + "Slug" + "} = '" + slug + "',{" + "Status" + "} = '" + "aktiv" + "')";
            }
        };

        Location location;

        try {
            List<Location> locationlist = getAirtableBase().table("Location", Location.class).select(slugQuery);

            if (locationlist.size() == 1) {
                location = locationlist.get(0);
            } else if (locationlist.size() > 1) {
                throw new LocationException("slug [" + slug + "] is not unique. Number of results: " + locationlist.size());

            } else {
                final String msg = "Location for slug '" + slug + "' not found.";
                log.error(msg);
                throw new LocationNotFoundException(msg);
            }

        } catch (AirtableException | LocationException e) {
            log.error(e.getMessage(), e);
            throw new LocationSyntaxException("Error. Could not retrieve Location for Slug: " + slug);
        }

        log.debug("<-- getLocationOfSlug. Retrieved Location from Airtable");
        return location;

    }

    /**
     * Get the full Locationname of a slug.
     *
     * @param slug
     * @return String
     */
    public String getLocationNameOfSlug(String slug) {

        log.debug("--> getLocationNameOfSlug. Slug: " + slug);

        Query slugQuery = getQueryWithFilter("Slug", slug);
        String locationName;

        try {
            List<Location> locationlist = getAirtableBase().table("Location", Location.class).select(slugQuery);

            if (locationlist.size() == 1) {
                Location location = locationlist.get(0);
                locationName = location.getName();
            } else if (locationlist.size() > 1) {
                throw new LocationException("slug [" + slug + "] is not unique. Number of results: " + locationlist.size());

            } else {

                final String msg = "Location for slug '" + slug + "' not found.";
                log.error(msg);
                throw new LocationNotFoundException(msg);
            }

        } catch (AirtableException | LocationException e) {
            log.error(e.getMessage(), e);
            throw new LocationSyntaxException("Error. Coould not get Location Name for Slug: " + slug);
        }



        log.debug("<-- getLocationNameOfSlug. Retrieved Locationname from Airtable");
        return locationName;

    }

}
