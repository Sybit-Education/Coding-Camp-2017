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
import com.sybit.r750explorer.repository.SponsorenRepository;
import com.sybit.r750explorer.repository.tables.Sponsor;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
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
public class SponsorenServiceTest {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Mock
    private SponsorenRepository sponsorenRepository;

    @InjectMocks
    private SponsorenService sponsorenService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getSponsorenListTest() {

        List<Sponsor> testList = new ArrayList<Sponsor>();

        Sponsor sp1 = new Sponsor();
        sp1.setName("Sponsor 1");
        sp1.setLink("Link");
        sp1.setDescription("Descript");
        
        List<Attachment> attList = new ArrayList<>();
        Attachment att = new Attachment();
        att.setFilename("TestAtt");
        sp1.setLogo(attList);
        
        Sponsor sp2 = new Sponsor();
        sp2.setName("Sponsor 2");

        testList.add(sp1);
        testList.add(sp2);

        Mockito.when(sponsorenRepository.getSponsoren()).thenReturn(testList);
        List<Sponsor> response = sponsorenService.getSponsorenList();
        
        assertEquals(testList.size(), response.size());
        assertEquals(response.get(0).getDescription(), sp1.getDescription());
        assertEquals(response.get(0).getLink(), sp1.getLink());
        assertEquals(response.get(0).getLogo(), sp1.getLogo());
        assertEquals(response.get(0).getName(), sp1.getName());

    }

}
