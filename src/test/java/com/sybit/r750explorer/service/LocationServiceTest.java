/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.service;

import com.sybit.airtable.vo.Attachment;
import com.sybit.r750explorer.repository.tables.Location;
import com.sybit.r750explorer.repository.LocationRepository;
import com.sybit.r750explorer.repository.SpielstandRepository;
import com.sybit.r750explorer.repository.tables.Medien;
import com.sybit.r750explorer.repository.tables.Spielstand;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
 *
 * @author fzr
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class LocationServiceTest {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Mock
    private LocationRepository locationRepository;
    @Mock
    private SpielstandRepository spielstandRepository;

    @InjectMocks
    private LocationService locationService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getLocationTest() {

        String testSlug = "slug";

        Location testLoc = new Location();
        testLoc.setName("Test 123");
        testLoc.setCode("testCode");
        testLoc.setDescription("Description");
        testLoc.setGeoLat("123");
        testLoc.setGeoLng("123");
        testLoc.setSlug("testSlug");
        testLoc.setCodeHinweis("Hinweis");
        testLoc.setGeoZoom("10");
        testLoc.setStatus("Status");

        List<String> medienList = new ArrayList<String>();
        medienList.add("Medie1");
        testLoc.setMedien(medienList);

        List<Attachment> attList = new ArrayList<>();
        Attachment att = new Attachment();
        att.setFilename("TestAtt");
        attList.add(att);
        testLoc.setPhoto(attList);

        testLoc.setCodeHintPhoto(attList);

        Mockito.when(locationRepository.getLocationOfSlug(testSlug)).thenReturn(testLoc);
        Location response = locationService.getLocation(testSlug);

        assertEquals(response, testLoc);
        assertEquals(response.getName(), "Test 123");
        assertEquals(response.getCode(), "testCode");
        assertEquals(response.getDescription(), "Description");
        assertEquals(response.getGeoLat(), "123");
        assertEquals(response.getGeoLng(), "123");
        assertEquals(response.getSlug(), "testSlug");
        assertEquals(response.getCodeHinweis(), "Hinweis");
        assertEquals(response.getGeoZoom(), "10");
        assertEquals(response.getStatus(), "Status");

        assertEquals(response.getMedien(), medienList);
        assertEquals(response.getPhoto(), attList);
        assertEquals(response.getCodeHintPhoto(), attList);

    }

    @Test
    public void getLocationsTest() {

        List<Location> locationList = new ArrayList<Location>();
        Location loc1 = new Location();
        Location loc2 = new Location();
        Location loc3 = new Location();

        locationList.add(loc1);
        locationList.add(loc2);
        locationList.add(loc3);

        Mockito.when(locationRepository.getLocationList()).thenReturn(locationList);
        List<Location> response = locationService.getLocations(null);

        assertEquals(response.size(), 3);

    }


    @Test
    public void getVisitedLocations() {

        String testUUID = "testuuid";

        List<Spielstand> spielstandList = new ArrayList<>();

        Spielstand sp1 = new Spielstand();
        List<String> locSP1 = new ArrayList<>();
        locSP1.add("id1");
        sp1.setLocationList(locSP1);

        Spielstand sp2 = new Spielstand();
        List<String> locSP2 = new ArrayList<>();
        locSP2.add("id2");
        sp2.setLocationList(locSP2);

        Spielstand sp3 = new Spielstand();
        List<String> locSP3 = new ArrayList<>();
        locSP3.add("id3");
        sp3.setLocationList(locSP3);

        Location loc1 = new Location();
        Location loc2 = new Location();
        Location loc3 = new Location();

        spielstandList.add(sp1);
        spielstandList.add(sp2);
        spielstandList.add(sp3);

        Mockito.when(spielstandRepository.getEntrysOfUUID(testUUID)).thenReturn(spielstandList);
        Mockito.when(locationRepository.getLocation("id1")).thenReturn(loc1);
        Mockito.when(locationRepository.getLocation("id2")).thenReturn(loc2);
        Mockito.when(locationRepository.getLocation("id3")).thenReturn(loc3);

        List<Location> response = locationService.getVisitedLocations(testUUID);

        assertNotNull(response);
        assertEquals(3, response.size());

    }

    @Test
    public void getVisitedLocationsKeinSpielstand() {

        String testUUID = "testuuid";

        List<Spielstand> spielstandList = new ArrayList<>();
        List<Location> visited = new ArrayList<>();

        Mockito.when(spielstandRepository.getEntrysOfUUID(testUUID)).thenReturn(spielstandList);

        List<Location> response = locationService.getVisitedLocations(testUUID);

        assertEquals(response, visited);

    }

    @Test
    public void getVisitedLocationsOneLocation() {

        String testUUID = "testuuid";

        List<Spielstand> spielstandList = new ArrayList<>();

        Spielstand sp1 = new Spielstand();
        List<String> locSP1 = new ArrayList<>();
        locSP1.add("id1");
        sp1.setLocationList(locSP1);

        Location loc1 = new Location();

        spielstandList.add(sp1);

        Mockito.when(spielstandRepository.getEntrysOfUUID(testUUID)).thenReturn(spielstandList);
        Mockito.when(locationRepository.getLocation("id1")).thenReturn(loc1);
        
        List<Location> response = locationService.getVisitedLocations(testUUID);

        assertNotNull(response);
        assertEquals(response.size(), 1);

    }
}
