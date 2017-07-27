package com.sybit.r750explorer.controller;

import com.sybit.r750explorer.Application;
import java.util.UUID;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class HomeControllerTest {

    @Autowired
    private MockMvc mvc;

    //TODO Extend Test atm only checks Status
    @Ignore
    @Test
    public void getHome() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/home.jsp"));
    }

    @Test
    public void getError() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/location"))
                .andExpect(status().is4xxClientError());

    }

}
