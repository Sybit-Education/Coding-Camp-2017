/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.repository;

/**
 *
 * @author fzr
 */



import com.sybit.r750explorer.Application;
import com.sybit.r750explorer.repository.tables.Sponsor;
import com.sybit.r750explorer.wiremock.wiremockBaseTest;
import java.util.List;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class SponsorenRepositoryTest extends wiremockBaseTest {
    
    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private SponsorenRepository sponsorenRepository;
    
    @Test
    public void getSponsorenTest() {
    
        List<Sponsor> sponsorenList = sponsorenRepository.getSponsoren();
        assertNotNull(sponsorenList);
        log.info(sponsorenList.get(0).getName());
    }
    
}
