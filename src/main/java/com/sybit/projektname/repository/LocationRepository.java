package com.sybit.projektname.repository;


import com.sybit.airtable.exception.AirtableException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fzr on 11.04.17.
 */
@Repository
public class LocationRepository extends AirtableRepository {


    public List getLocationList()  {

        try {
            return getAirtableBase().table("Location", Location.class).select();
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
            return (Location) getAirtableBase().table("Location",Location.class).find(id);
        } catch (AirtableException e) {
            e.printStackTrace();
            return null;
        }
    }



}
