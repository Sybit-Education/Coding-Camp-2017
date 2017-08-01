package com.sybit.r750explorer.service;

import com.sybit.r750explorer.repository.tables.Location;
import com.sybit.r750explorer.repository.LocationRepository;
import com.sybit.r750explorer.repository.SpielstandRepository;
import com.sybit.r750explorer.repository.tables.Spielstand;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.el.MethodNotFoundException;
import org.slf4j.LoggerFactory;

/**
 * Created by fzr on 13.04.17.
 */
@Service
public class LocationService {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private SpielstandRepository spielstandRepository;

    //Diese drin lassen für Startseite
    /**
     * Get a List of all Locations.
     *
     * @param uuid Cookie-ID of the user
     * @return List of Locations
     */
    public List getLocations(String uuid) {

        log.debug("--> getLocations");

        final List<Location> locationList = locationRepository.getLocationList();

        List<Location> locationVisitedList = this.getVisitedLocations(uuid);

        for (Location location : locationList) {
            if (locationVisitedList.contains(location)) {
                location.setVisited(true);
            } else {
                location.setVisited(false);
            }
        }

        log.debug("<-- getLocations size: " + locationList.size());
        return locationList;
    }

    /**
     * Get a single Location specified by the slug.
     *
     * @param slug
     * @return Location
     */
    public Location getLocation(String slug) {

        //Hole eine Location anhand ihres Slugs
        log.debug("--> getLocation: Slug: " + slug);
        
        Location loc = locationRepository.getLocationOfSlug(slug);
        
        return loc;
    }
    
    

    /**
     * Return a List with all visited Location. Gets spielstand Entrys and
     * checks the Locations.
     *
     * @param uuid Cookie-ID of the user
     * @return List of Visited Location
     */
    public List<Location> getVisitedLocations(String uuid) {

        log.debug("--> getVisitedLocations. UUID: " + uuid);
        
        //Hole dir zuerst die Spielstände und ermittle anhand von diesen einträgen schon besuchte locations
        List<Spielstand> Entrys = spielstandRepository.getEntrysOfUUID(uuid);
        List<Location> visited = new ArrayList<>();
        for (Spielstand Entry : Entrys) {
            if (Entry.getLocationList() != null) {
                for (String Locationid : Entry.getLocationList()) {
                    visited.add(locationRepository.getLocation(Locationid));
                }
            } else {
                log.debug(Entry + "Has no locations");
            }
        }
        
        log.debug("<-- getVisitedLocations. size: " + visited.size());
        return visited;
    }
}
