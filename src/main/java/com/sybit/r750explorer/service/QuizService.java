package com.sybit.r750explorer.service;

import com.sybit.r750explorer.exception.FrageException;
import com.sybit.r750explorer.repository.tables.Fragen;
import com.sybit.r750explorer.repository.QuizRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.el.MethodNotFoundException;

/**
 * Created by yms on 16.05.2017.
 */
@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    
    /**
     * Get a random Frage from a Location specified by its Slug.
     *
     * @param slug
     * @return Fragen
     * @throws FrageException if no Fragen exist for specified Location
     */
    
    public Fragen getFrageOfLocation(String slug) throws FrageException {

        log.debug("--> getFragenOfLocation: Slug: " + slug);
        //Fragenliste erstellen
        

        //zufällige Zahl wählen aus der Anzahl der Fragen in der Fragenliste
       
        //Fragenlisten, die nur eine Frage enthalten, sollen nur diese ausgeben
       
        //Fehlermeldung, wenn keine Fragen in der Fragenliste enthalten sind
        
        throw new MethodNotFoundException("Methode nicht implementiert.");
    }

    /**
     * Get a single Frage specified by its id.
     *
     * @param id
     * @return Fragen
     */
    
    public Fragen getFrageOfID(String id) {

        log.debug("--> getFrageOfID: ID: " + id);
       return quizRepository.getFrageOfId(id);
       
        
    }
}