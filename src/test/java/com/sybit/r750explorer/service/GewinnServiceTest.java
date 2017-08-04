/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.service;

import com.sybit.r750explorer.repository.GewinnRepository;
import com.sybit.r750explorer.repository.tables.Gewinn;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Schüler
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class GewinnServiceTest {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Mock
    private GewinnRepository gewinnRepository;

    @InjectMocks
    private GewinnService gewinnService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void GewinnServiceTest() {

        List<Gewinn> testGewinn = new ArrayList<>();
        Gewinn gew1 = new Gewinn();
        gew1.setBemerkung("test bemerkung");
        gew1.setName("testName");
        testGewinn.add(gew1);
        Mockito.when(gewinnRepository.getAll()).thenReturn(testGewinn);
        List<Gewinn> response = gewinnService.getGewinnList();

        assertEquals(testGewinn, response);

    }

    @Test
    public void getGewinnOfMonthTest() {

        List<Gewinn> testGewinn = new ArrayList<>();
        Gewinn gew1 = new Gewinn();
        gew1.setBemerkung("test bemerkung");
        gew1.setName("testName");
        gew1.setVerlosungsmonat("2017-08-23");
        testGewinn.add(gew1);
        Mockito.when(gewinnRepository.getAll()).thenReturn(testGewinn);
        List<Gewinn> response = gewinnService.getGewinnOfMonth();

        assertEquals(testGewinn, response);
    }
}
