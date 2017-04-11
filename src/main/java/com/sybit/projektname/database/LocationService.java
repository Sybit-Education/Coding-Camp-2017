package com.sybit.projektname.database;


import com.sybit.airtable.exception.AirtableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fzr on 11.04.17.
 */
@Service
public class LocationService {

    @Autowired
    private AirtableService airtableService;

    public List<Location> getLocations() throws AirtableException {

       return null;//airtableService.getAirtableBase().table("Location", Location.class).select();

    }

    public Location getLocation(String id){

        return null;//airtableService.getAirtableBase().table("Location",Location.class).find("STRING_ID");
    }

}
