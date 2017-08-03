package com.sybit.r750explorer.repository;

import com.sybit.r750explorer.repository.tables.Fragen;
import com.sybit.r750explorer.Application;
import com.sybit.r750explorer.wiremock.wiremockBaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import org.junit.Ignore;

/**
 * Created by yms on 15.05.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class QuizRepositoryTest extends wiremockBaseTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private QuizRepository quizRepository;

    @Test
    public void getFragenOfLocationTest() {

        List<Fragen> fragenList = quizRepository.getFragenOfLocation("muenster");
        assertNotNull(fragenList);
        assertEquals(fragenList.size(), 3);
    }

    @Test
    public void getFrageOfID() {

        Fragen frage = quizRepository.getFrageOfId("recBwoenWxxLiEnQz");
        assertNotNull(frage);
        assertEquals(frage.getFrage(), "Wie viele Glocken hat der Turm des Münsters?");
    }
}
