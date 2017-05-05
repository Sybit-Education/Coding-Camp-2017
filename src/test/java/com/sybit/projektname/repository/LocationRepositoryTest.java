package com.sybit.projektname.repository;

import com.sybit.projektname.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by fzr on 19.04.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class LocationRepositoryTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private LocationRepository locationRepository;


    @Test
    public void getLocationTest() {

        Location loc = locationRepository.getLocation("hoellturm");
        assertEquals(loc.getName(),"Höllturm");

    }
}

