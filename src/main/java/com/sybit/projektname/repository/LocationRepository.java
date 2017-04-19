package com.sybit.projektname.repository;


import com.sybit.airtable.Query;
import com.sybit.airtable.Sort;
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

    public Location getLocation(String slug)  {


        Query slugQuery = new Query() {
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
                return null;
            }

            @Override
            public String filterByFormula() {
                return "({Slug} = '"+slug+"')";
            }
        };

        List<Location> locationlist = null;

        try {
             locationlist = getAirtableBase().table("Location", Location.class).select(slugQuery);
        } catch (AirtableException e) {
            e.printStackTrace();
        }

        for(Location loc : locationlist){
            System.out.println(loc.getName());
        }

        if(locationlist.size() <= 1 && locationlist != null){
            return locationlist.get(0);
        }

        return null;
    }





}
