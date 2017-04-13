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

    public List getLocations()  {

        try {
            return airtableService.getAirtableBase().table("Location", Location.class).select();
        } catch (AirtableException e) {
            e.printStackTrace();
            return null;
        } catch (org.apache.http.client.HttpResponseException e) {
            e.printStackTrace();
            return null;
        }

    }

    public Location getLocation(String id)  {

        try {
            return (Location) airtableService.getAirtableBase().table("Location",Location.class).find(id);
        } catch (AirtableException e) {
            e.printStackTrace();
            return null;
        }
    }

}
