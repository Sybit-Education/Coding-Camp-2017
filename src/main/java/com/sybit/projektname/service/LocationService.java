package com.sybit.projektname.service;

import com.sybit.projektname.repository.Location;
import com.sybit.projektname.repository.LocationRepository;
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

    public Location getLocation(String id){

        return locationRepository.getLocation(id);
    }
}
