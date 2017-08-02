/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.service;

import com.sybit.r750explorer.repository.tables.Highscore;
import com.sybit.r750explorer.repository.tables.Location;
import com.sybit.r750explorer.repository.LocationRepository;
import com.sybit.r750explorer.repository.tables.Spielstand;
import com.sybit.r750explorer.repository.SpielstandRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author fzr
 */


@RunWith(SpringJUnit4ClassRunner.class)
public class ScoreServiceTest {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Mock
    private SpielstandRepository spielstandRepository;

    @Mock
    private LocationRepository locationRepository;

    @InjectMocks
    private ScoreService scoreService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Ignore
    @Test
    public void newSpielstandEntryTest() {

        Location testLoc = new Location();
        testLoc.setId("locId");
        testLoc.setName("TestLoca");
        String testUUID = "testuuid";

        Spielstand update = new Spielstand();
        update.setUuid(testUUID);
        update.setScore(String.valueOf(Float.valueOf(10)));
        List<String> questionList = new ArrayList<>();
        questionList.add("1");
        update.setQuestionList(questionList);
        update.setUserAnswerIndex("2");
        List<String> locationIds = new ArrayList<>();
        locationIds.add(testLoc.getId());
        update.setLocationList(locationIds);

        Mockito.when(spielstandRepository.newEntry(any())).thenReturn(update);
        Spielstand response = scoreService.newSpielstandEntry(testUUID, testLoc, "1", "2", Float.valueOf(10));

        assertNotNull(response);
        assertEquals(response.getLocationList(), update.getLocationList());
        assertEquals(response.getQuestionList(), update.getQuestionList());
        assertEquals(response.getScore(), update.getScore());
        assertEquals(response.getUserAnswerIndex(), update.getUserAnswerIndex());
        assertEquals(response.getUuid(), update.getUuid());

    }

    @Ignore
    @Test
    public void newSpielstandEntryWithNullTest() {

        String testUUID = "testuuid";

        Spielstand update = new Spielstand();
        update.setUuid(testUUID);
        update.setScore("100");
        List<String> questionList = new ArrayList<>();

        update.setQuestionList(questionList);
        update.setUserAnswerIndex("Test");
        List<String> locationIds = new ArrayList<>();
        update.setLocationList(locationIds);

        Mockito.when(spielstandRepository.newEntry(any())).thenReturn(update);
        Spielstand response = scoreService.newSpielstandEntry(testUUID, null, null, "2", Float.valueOf("10"));

        assertNotNull(response);
        assertEquals(response.getLocationList(), update.getLocationList());
        assertEquals(response.getQuestionList(), update.getQuestionList());
        assertEquals(response.getScore(), update.getScore());
        assertEquals(response.getUserAnswerIndex(), update.getUserAnswerIndex());
        assertEquals(response.getUuid(), update.getUuid());

    }

    @Ignore
    @Test
    public void getScoreOfSpielstand() {

        String testUUID = "testuuid";

        List<Spielstand> entrys = new ArrayList<>();
        Spielstand sp1 = new Spielstand();
        sp1.setScore("100");
        Spielstand sp2 = new Spielstand();
        sp2.setScore("20");
        Spielstand sp3 = new Spielstand();
        sp3.setScore("10");
        entrys.add(sp1);
        entrys.add(sp2);
        entrys.add(sp3);

        Mockito.when(spielstandRepository.getEntrysOfUUID(testUUID)).thenReturn(entrys);
        Float result = scoreService.getScoreOfSpielstand(testUUID);

        assertEquals(String.valueOf(result), "130.0");

    }

    @Ignore
    @Test
    public void getHighscoreListTest() {

        String testUUID = "testUUID";
        String testNickname = "nickname";
        Float testscore = Float.valueOf("10");
        String testdate = "testdate";

        List<Highscore> response = new ArrayList<>();
        Highscore e = new Highscore();
        e.setUuid(testUUID);
        e.setNickname(testNickname);
        e.setScore(testscore);
        e.setDate(testdate);
        response.add(e);

        Mockito.when(spielstandRepository.getHighscore()).thenReturn(response);
        List<Highscore> list = scoreService.getHighscoreList();

        assertNotNull(list);
        assertEquals(list.get(0), e);

    }

    @Ignore
    @Test
    public void checkIfPlayerExistsTest() {

        String testUUID = "testuuid";

        Mockito.when(spielstandRepository.getHighscoreOfUUID(testUUID)).thenReturn(null);
        Boolean response = scoreService.checkIfPlayerExists(testUUID);

        assertEquals(response, false);
    }

    @Ignore
    @Test
    public void newHighscoreTest() {

        String testNickname = "nickname";
        String testEmail = "email";
        String testUUID = "uuid";

        Highscore newHighscore = new Highscore();
        newHighscore.setNickname(testNickname);
        newHighscore.setEmail(testEmail);
        newHighscore.setUuid(testUUID);
        newHighscore.setScore(Float.valueOf("20"));
        newHighscore.setDate("datum");

        Mockito.when(spielstandRepository.registerScore(any())).thenReturn(newHighscore);
        Highscore response = scoreService.newHighscore(testNickname, testEmail, testUUID);

        assertEquals(response, newHighscore);
    }

    @Ignore
    @Test
    public void newHighscoreFailedTest() {

        String testNickname = "nickname";
        String testEmail = "email";
        String testUUID = "uuid";

        Mockito.when(spielstandRepository.registerScore(any())).thenReturn(null);
        Highscore response = scoreService.newHighscore(testNickname, testEmail, testUUID);

        assertEquals(response, null);
    }

    @Ignore
    @Test
    public void removeHighscoreTest() {

        String testUUID = "0123456";
        Mockito.doNothing().when(spielstandRepository).deleteHighscore(testUUID);

        scoreService.removeHighscore(testUUID);

    }

    @Ignore
    @Test
    public void formatHighscoreTest() {

        List<Highscore> highscoreTestList = new ArrayList<>();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();

        Highscore h1 = new Highscore();
        h1.setDate(dateFormat.format(date));

        highscoreTestList.add(h1);

        List<Highscore> response = scoreService.formatHighscoreList(highscoreTestList);

        assertEquals(10, response.get(0).getDate().length());

    }

    
    @Test
    public void hintRequestedOver5() {
        String testUUID = "1234";
        List<Spielstand> entrys = new ArrayList<>();
        Spielstand sp1 = new Spielstand();
        sp1.setScore("10");
        Spielstand sp2 = new Spielstand();
        sp2.setScore("10");
        Spielstand sp3 = new Spielstand();
        sp3.setScore("10");
        entrys.add(sp1);
        entrys.add(sp2);
        entrys.add(sp3);

        Mockito.when(spielstandRepository.getEntrysOfUUID("1234")).thenReturn(entrys);
        //Mockito.when(scoreService.getScoreOfSpielstand("1234")).thenReturn(Float.valueOf(100));
        Float response = scoreService.hintRequested("1234");
        assertEquals(Float.valueOf(-5), response);

    }

    
    @Test
    public void hintRequested0() {
        String testUUID = "1234";
        List<Spielstand> entrys = new ArrayList<>();
        Spielstand sp1 = new Spielstand();
        sp1.setScore("10");
        Spielstand sp2 = new Spielstand();
        sp2.setScore("-5");
        Spielstand sp3 = new Spielstand();
        sp3.setScore("-5");
        entrys.add(sp1);
        entrys.add(sp2);
        entrys.add(sp3);

        Mockito.when(spielstandRepository.getEntrysOfUUID("1234")).thenReturn(entrys);
        //Mockito.when(scoreService.getScoreOfSpielstand("1234")).thenReturn(Float.valueOf("0"));
        Float response = scoreService.hintRequested("1234");
        assertEquals(Float.valueOf(0), response);

    }
    
    @Test
    public void hintBetween1and4(){

        String testUUID = "1234";
        List<Spielstand> entrys = new ArrayList<>();
        Spielstand sp1 = new Spielstand();
        sp1.setScore("10");
        Spielstand sp2 = new Spielstand();
        sp2.setScore("-5");
        Spielstand sp3 = new Spielstand();
        sp3.setScore("1");
        Spielstand sp4 = new Spielstand();
        sp4.setScore("-5");
        
        entrys.add(sp1);
        entrys.add(sp2);
        entrys.add(sp3);
        entrys.add(sp4);
        
        Mockito.when(spielstandRepository.getEntrysOfUUID("1234")).thenReturn(entrys);
        //Mockito.when(scoreService.getScoreOfSpielstand("1234")).thenReturn(Float.valueOf("0"));
        Float response = scoreService.hintRequested("1234");
        assertEquals(Float.valueOf(-1), response);
    }
}
