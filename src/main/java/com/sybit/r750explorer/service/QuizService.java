package com.sybit.r750explorer.service;

import com.sybit.r750explorer.exception.FrageException;
import com.sybit.r750explorer.repository.tables.Fragen;
import com.sybit.r750explorer.repository.QuizRepository;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.el.MethodNotFoundException;
//import javax.el.FrageNotFoundException;

import java.util.Random;

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
        List<Fragen> fragenList=quizRepository.getFragenOfLocation(slug);

        
       int anzFragen=fragenList.size();
       Fragen frage;
       if (anzFragen==1){
           //Fragenlisten, die nur eine Frage enthalten, sollen nur diese ausgeben
           frage=fragenList.get(0);            
       }
       else if(anzFragen>1){
           //zufällige Zahl wählen aus der Anzahl der Fragen in der Fragenliste
           Random randGenerator=new Random();       
           int zufall=randGenerator.nextInt(anzFragen-1);
           frage=fragenList.get(zufall);         
       }
       else{
           //Fehlermeldung, wenn keine Fragen in der Fragenliste enthalten sind
           throw new FrageException("Keine Fragen zu dieser Location vorhanden.");
       }
        
       return frage;        
        
        
    }

    /**
     * Get a single Frage specified by its id.
     *
     * @param id
     * @return Fragen
     */
    
    public Fragen getFrageOfID(String id) throws FrageException {

        log.debug("--> getFrageOfID: ID: " + id);
        //Hole dir die Frage anhand ihrer ID
        Fragen frage=quizRepository.getFrageOfId(id);
        if (frage==null){
            throw new FrageException("Methode nicht implementiert.");
        }
        return frage;
    }
}