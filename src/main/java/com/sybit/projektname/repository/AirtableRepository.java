package com.sybit.projektname.repository;

import com.sybit.airtable.Airtable;
import com.sybit.airtable.Base;
import com.sybit.airtable.exception.AirtableException;
import org.springframework.stereotype.Repository;

/**
 * Created by fzr on 10.04.17.
 */

@Repository
public class AirtableRepository {

    Base base = null;
    protected Base getAirtableBase() throws AirtableException {

        if(base == null) {
            Airtable airtable = new Airtable();
            airtable.configure("keyfb9Awkpq9G05BX");
            base = airtable.base("appDZ609ies85XW1D");
        }
        return base;
    }


}
