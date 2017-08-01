package com.sybit.r750explorer.service;

import com.sybit.airtable.vo.Attachment;
import com.sybit.r750explorer.exception.FrageException;
import com.sybit.r750explorer.repository.tables.Fragen;
import com.sybit.r750explorer.repository.QuizRepository;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yms on 19.05.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class QuizServiceTest {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Mock
    private QuizRepository quizRepository;

    @InjectMocks
    private QuizService quizService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Ignore
    @Test
    public void getFrageOfLocationTest() throws Exception {

        String testSlug = "slug";

        Fragen testFrage = new Fragen();
        testFrage.setFrage("Frage");
        testFrage.setAntwort1("Antw1");
        testFrage.setAntwort2("Antw2");
        testFrage.setAntwort3("Antw3");
        testFrage.setId("id");
        testFrage.setLoesung(Float.parseFloat("1"));
        testFrage.setLoesungText("Text");
        List<String> locList = new ArrayList<>();
        locList.add("loc");
        testFrage.setLocation(locList);

        List<Attachment> attList = new ArrayList<>();
        Attachment att = new Attachment();
        att.setFilename("TestAtt");
        testFrage.setBild(attList);

        List<Fragen> fragenList = new ArrayList<>();

        fragenList.add(testFrage);

        Mockito.when(quizRepository.getFragenOfLocation(testSlug)).thenReturn(fragenList);

        Fragen response = quizService.getFrageOfLocation(testSlug);
        assertEquals(response.getFrage(), "Frage");
        assertEquals(response.getAntwort1(), "Antw1");
        assertEquals(response.getAntwort2(), "Antw2");
        assertEquals(response.getAntwort3(), "Antw3");
        assertEquals(response.getId(), "id");
        assertEquals(response.getLoesung(), Float.parseFloat("1"), Float.valueOf("0"));
        assertEquals(response.getLoesungText(), "Text");
        assertEquals(response.getBild(), attList);
        assertEquals(response.getLocation(), locList);

    }

    @Ignore
    @Test(expected = FrageException.class)
    public void getFrageOfLocationExceptionTest() throws Exception {

        String testSlug = "slug";
        List<Fragen> fragenList = new ArrayList<>();

        Mockito.when(quizRepository.getFragenOfLocation(testSlug)).thenReturn(fragenList);

        Fragen response = quizService.getFrageOfLocation(testSlug);

    }

    @Ignore
    @Test
    public void getFrageOfLocationRandomTest() throws Exception {

        String testSlug = "slug";

        List<Fragen> fragenList = new ArrayList<>();

        Fragen frage1 = new Fragen();
        frage1.setFrage("Frage1");
        frage1.setAntwort1("1Antw1");
        frage1.setAntwort2("Antw2");
        frage1.setAntwort3("Antw3");
        frage1.setId("F1id");
        frage1.setLoesung(Float.parseFloat("1"));
        frage1.setLoesungText("Text F1");
        List<String> locList = new ArrayList<>();
        locList.add("loc");
        frage1.setLocation(locList);
        List<Attachment> attList = new ArrayList<>();
        Attachment att = new Attachment();
        att.setFilename("TestAtt");
        frage1.setBild(attList);

        Fragen frage2 = new Fragen();
        frage2.setFrage("Frage2");
        frage2.setAntwort1("1Antw1");
        frage2.setAntwort2("Antw2");
        frage2.setAntwort3("Antw3");
        frage2.setId("F1id");
        frage2.setLoesung(Float.parseFloat("1"));
        frage2.setLoesungText("Text F1");
        List<String> locList2 = new ArrayList<>();
        locList2.add("loc");
        frage1.setLocation(locList2);
        List<Attachment> attList2 = new ArrayList<>();
        Attachment att2 = new Attachment();
        att2.setFilename("TestAtt");
        frage1.setBild(attList2);

        fragenList.add(frage1);
        fragenList.add(frage2);

        Mockito.when(quizRepository.getFragenOfLocation(testSlug)).thenReturn(fragenList);

        Fragen response = quizService.getFrageOfLocation(testSlug);
        
        assertThat(response,anyOf(is(frage1),is(frage2)));

    }

    @Ignore
    @Test
    public void getFrageOfIDTest() {

        String testId = "001";
        Fragen testFrage = new Fragen();
        testFrage.setFrage("Test Frage");

        Mockito.when(quizRepository.getFrageOfId(testId)).thenReturn(testFrage);

        Fragen response = quizService.getFrageOfID(testId);
        assertEquals(testFrage.getFrage(), response.getFrage());
    }
}
