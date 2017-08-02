/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.service;

import com.sybit.airtable.vo.Attachment;
import com.sybit.r750explorer.repository.LocationRepository;
import com.sybit.r750explorer.repository.tables.Medien;
import com.sybit.r750explorer.repository.MedienRepository;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.LoggerFactory;

/**
 *
 * @author fzr
 */
public class MedienServiceTest {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Mock
    private MedienRepository medienRepository;

    @Mock
    private LocationRepository locationRepository;

    @InjectMocks
    private MedienService medienService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getMedienOfLocationNameTest() {

        String testName = "testname";

        List<Medien> testList = new ArrayList<>();

        Medien m1 = new Medien();
        m1.setType("Text");
        m1.setUeberschrift("TestÜb");
        m1.setText("Text");
        m1.setSort("1");
        m1.setQuelle("Quelle");
        m1.setLink("Link");
        
        List<String> locList = new ArrayList<>();
        locList.add("location");
        m1.setLocation(locList);
        
        List<Attachment> attList = new ArrayList<>();
        Attachment att = new Attachment();
        att.setFilename("TestAtt");
        m1.setAttachements(attList);

        Medien m2 = new Medien();
        m2.setType("Foto");

        Medien m3 = new Medien();
        m3.setType("Link");

        testList.add(m1);
        testList.add(m2);
        testList.add(m3);

        Mockito.when(medienRepository.getMedienOfLocationName(testName)).thenReturn(testList);
        List<Medien> response = medienService.getMedienOfLocationName(testName);

        assertEquals(response, testList);
        assertEquals(response.get(0),testList.get(0));
        assertEquals(response.get(0).getUeberschrift(),testList.get(0).getUeberschrift());
        assertEquals(response.get(0).getType(),testList.get(0).getType());
        assertEquals(response.get(0).getText(),testList.get(0).getText());
        assertEquals(response.get(0).getSort(),testList.get(0).getSort());
        assertEquals(response.get(0).getQuelle(),testList.get(0).getQuelle());
        assertEquals(response.get(0).getLocation(),testList.get(0).getLocation());
        assertEquals(response.get(0).getLink(),testList.get(0).getLink());
        assertEquals(response.get(0).getAttachements(),testList.get(0).getAttachements());
        

    }

    @Test
    public void getMedienOfLocationSlugTest() {

        String testslug = "testslug";
        String name = "locaName";

        List<Medien> testList = new ArrayList<>();

        Medien m1 = new Medien();
        m1.setType("Text");

        Medien m2 = new Medien();
        m2.setType("Foto");

        Medien m3 = new Medien();
        m3.setType("Link");

        testList.add(m1);
        testList.add(m2);
        testList.add(m3);

        Mockito.when(medienRepository.getMedienOfLocationName(name)).thenReturn(testList);
        Mockito.when(locationRepository.getLocationNameOfSlug(testslug)).thenReturn(name);
        List<Medien> response = medienService.getMedienOfLocationSlug(testslug);

        assertEquals(response, testList);

    }

}
