package com.sybit.r750explorer.repository;

import com.sybit.r750explorer.repository.tables.Medien;
import com.sybit.r750explorer.Application;
import com.sybit.r750explorer.wiremock.wiremockBaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.junit.Assert.assertNotNull;

/**
 * Created by fzr on 09.05.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class MedienRepositoryTest extends wiremockBaseTest {

    @Autowired
    private MedienRepository medienRepository;


    @Test
    public void getMedienOfLocationNameTest() {

        List<Medien> test = medienRepository.getMedienOfLocationName("Stadttor (Obertor an der Brücke)");
        assertNotNull(test);
    }


}