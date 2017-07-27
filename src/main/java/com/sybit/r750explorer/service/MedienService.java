package com.sybit.r750explorer.service;

import com.sybit.r750explorer.repository.LocationRepository;
import com.sybit.r750explorer.repository.MedienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.el.MethodNotFoundException;
import org.slf4j.LoggerFactory;

/**
 * Created by fzr on 09.05.17.
 */
@Service
public class MedienService {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MedienRepository medienRepository;

    @Autowired
    private LocationRepository locationRepository;
    

    /**
     * Get a List of Medien of a Location specified by its Name.
     * Eine Methode die die Medien-Daten einer Location anhand ihres Namens liefert.
     *
     * @param name Name
     * @return List of Medien
     */
    public List getMedienOfLocationName(String name) {

        log.debug("--> getMedienOfLocationName: Name: " + name);
        
        
        //Hole dir die MedienDaten
        throw new MethodNotFoundException("Methode nicht implementiert");
    }

    /**
     * Get a List of Medien of a Location specified by its Slug.
     * Eine Methode die die Medien-Daten einer Location anhand ihres Slugs liefert.
     *
     * @param slug
     * @return List of Medien
     */
    public List getMedienOfLocationSlug(String slug) {

        log.debug("--> getMedienOfLocationSlug: Slug: " + slug);
        //Wenn ich den Name der Location hätte könnte ich die obere Methode wiederverwenden....
        throw new MethodNotFoundException("Methode nicht implementiert");
    }

}
