package com.sybit.projektname.database;

import com.sybit.airtable.Airtable;
import com.sybit.airtable.Base;
import com.sybit.airtable.Table;
import com.sybit.airtable.exception.AirtableException;
import org.springframework.stereotype.Service;

/**
 * Created by fzr on 10.04.17.
 */

@Service
public class AirtableService {

    public Base getAirtableBase() throws AirtableException {

        Airtable airtable = new Airtable();
        airtable.configure("keyrguODZpsZdrPRd");
        Base base = airtable.base("appDZ609ies85XW1D");

        return base;
    }

    public Table getLocationTable() throws AirtableException {

        return getAirtableBase().table("Location",Location.class);
    }


}
