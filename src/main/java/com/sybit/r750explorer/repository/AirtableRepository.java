package com.sybit.r750explorer.repository;

import com.sybit.airtable.Airtable;
import com.sybit.airtable.Base;
import com.sybit.airtable.Configuration;
import com.sybit.airtable.Query;
import com.sybit.airtable.Sort;
import com.sybit.airtable.exception.AirtableException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by fzr on 10.04.17.
 */
@Repository
public class AirtableRepository {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());
    Base base = null;
    Properties prop;

    /**
     * Creates a Airtable Base which is used for all repositorys.
     *
     * @return
     * @throws AirtableException
     */
    protected Base getAirtableBase() throws AirtableException {

        log.debug("--> getAirtableBase");

        if (base == null) {

            Airtable airtable = new Airtable();
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream is = null;
            try {                
                is =  classLoader.getResourceAsStream("airtable.properties");
            } catch (NullPointerException e) {
                log.warn("No Propertie File found!");
            }

            if (is != null && propertiesExist(is)) {
                final Configuration configuration = new Configuration(null);
                if (prop.getProperty("AIRTABLE_API_KEY") != null) {
                    configuration.setApiKey(prop.getProperty("AIRTABLE_API_KEY"));
                }
                if (prop.getProperty("ENDPOINT_URL") != null) {
                    configuration.setEndpointUrl(prop.getProperty("ENDPOINT_URL"));
                }
                if (prop.getProperty("PROXY") != null) {
                    configuration.setProxy(prop.getProperty("PROXY"));
                }
                airtable.configure(configuration);
                if (prop.getProperty("AIRTABLE_BASE") != null) {
                    base = airtable.base(prop.getProperty("AIRTABLE_BASE"));
                }
                log.info("Airtable configured with Properties!");
            } else {
                airtable.configure();
                base = airtable.base("appDZ609ies85XW1D");
                log.info("Airtable configured manually.");
            }

        }
        return base;
    }

    /**
     * Creates a Query with a Filter.
     *
     * @param key
     * @param value
     * @return Query Object
     */
    protected Query getQueryWithFilter(String key, String value) {

        log.debug("--> getQueryWithFilter. Key: " + key + ". Value: " + value);

        Query query = new Query() {
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
                return "({" + key + "} = '" + value + "')";
            }
        };

        return query;
    }

    /**
     * Checks if a valid Property File exists.
     *
     * @param propertiesFile
     * @return boolean
     */
    private boolean propertiesExist(InputStream is) {

        log.debug("--> propertiesExist");

        Properties propl = new Properties();
        InputStream input = null;
        boolean exists = false;

        try {


            propl.load(is);

            exists = propl.getProperty("AIRTABLE_API_KEY") != null
                    && propl.getProperty("ENDPOINT_URL") != null
                    && propl.getProperty("AIRTABLE_BASE") != null;
            if (exists) {
                this.prop = propl;
            }

        } catch (IOException ex) {
            log.error("PropertiesFile corrupted!" + ex);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    log.error("Cant close Input!");
                }
            }
        }

        return exists;
    }

}
