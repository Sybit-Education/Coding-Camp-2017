package com.sybit.r750explorer.service;

import com.sybit.r750explorer.repository.Location;
import com.sybit.r750explorer.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fzr on 13.04.17.
 */
@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List getLocations(){

        return locationRepository.getLocationList();

    }

    public Location getLocation(String slug){

        return locationRepository.getLocation(slug);
    }
}
