/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.repository;

import com.sybit.r750explorer.repository.tables.Highscore;
import com.sybit.r750explorer.repository.tables.Spielstand;
import com.sybit.airtable.exception.AirtableException;
import com.sybit.r750explorer.Application;
import com.sybit.r750explorer.wiremock.wiremockBaseTest;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author fzr
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class SpielstandRepositoryTest extends wiremockBaseTest {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SpielstandRepository spielstandRepository;

    @Ignore
    @Test
    public void createSpielstandEntryTest() throws AirtableException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        Spielstand test = new Spielstand();
        List<String> locationList = new ArrayList<String>();
        locationList.add("recTYixrevYumxv87");
        test.setLocationList(locationList);
        test.setUuid("testUUID");
        test.setScore("testScore");
        List<String> fragenList = new ArrayList<String>();
        fragenList.add("recBwoenWxxLiEnQz");
        test.setQuestionList(fragenList);
        test.setUserAnswerIndex("tstIndex");
        Spielstand response = spielstandRepository.newEntry(test);

        assertNotNull(response);
    }

    @Ignore
    @Test
    public void createSpielstandEntryWithNullTest() throws AirtableException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        Spielstand test = new Spielstand();

        test.setUuid("testUUID");
        test.setScore("testScore");
        test.setUserAnswerIndex("TestString");
        Spielstand response = spielstandRepository.newEntry(test);

        assertNotNull(response);
    }

    @Ignore
    @Test
    public void getEntrysByUUIDTest() {

        List<Spielstand> entrys = spielstandRepository.getEntrysOfUUID("testUUID");
        assertNotNull(entrys);

    }

    @Ignore
    @Test
    public void getHighscoreOfUUIDTest() {

        String uuid = "111111";

        List<Highscore> response = spielstandRepository.getHighscoreOfUUID(uuid);
        assertNotNull(response);

    }

    @Test
    public void getHighscoreTest() {

        List<Highscore> highscoreList = spielstandRepository.getHighscore();
        assertNotNull(highscoreList);

    }

    @Ignore
    @Test
    public void registerScoreTest() {

        Highscore newHighscore = new Highscore();
        newHighscore.setNickname("nickname");
        newHighscore.setEmail("email");
        newHighscore.setUuid("uuid");
        newHighscore.setScore(Float.valueOf(10));

        newHighscore.setDate("2017-05-19 11:32:31");

        spielstandRepository.registerScore(newHighscore);
    }

    @Ignore
    @Test
    public void getIdOfHighscore() {

        String response;

        
        response = spielstandRepository.getIdOfHighscore("111111");
        assertNotNull(response);

    }

    @Ignore
    @Test
    public void deleteHighscore() {

        spielstandRepository.deleteHighscore("uuid");

    }
}
