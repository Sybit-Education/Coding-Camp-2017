package com.sybit.r750explorer.repository;

import com.sybit.r750explorer.repository.tables.Location;
import com.sybit.r750explorer.Application;
import com.sybit.r750explorer.wiremock.wiremockBaseTest;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by fzr on 19.04.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class LocationRepositoryTest extends wiremockBaseTest {

    @Autowired
    private LocationRepository locationRepository;


    @Test
    public void getLocationOfSlugTest() {

        Location loc = locationRepository.getLocationOfSlug("rathaus");
        assertNotNull(loc);
        assertEquals(loc.getName(),"Rathaus");

    }
    
    @Test
    public void getLocationListTest(){
        
        List<Location> locationList = locationRepository.getLocationList();
        assertNotNull(locationList);
    }
    
    @Test 
    public void getLocationTest(){
        
        Location location = locationRepository.getLocation("recpJf3sxsVuFc4fW");
        assertNotNull(location);
    }
    
    @Test
    public void getLocationNameOfSlug(){
        
        String name = locationRepository.getLocationNameOfSlug("hoellturm");
        assertNotNull(name);
    }
}

