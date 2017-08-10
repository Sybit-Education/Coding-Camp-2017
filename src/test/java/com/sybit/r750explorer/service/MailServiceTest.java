/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.service;

import com.sybit.r750explorer.exception.MailException;
import javax.mail.MessagingException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.slf4j.LoggerFactory;

/**
 *
 * @author fzr
 */
public class MailServiceTest {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @InjectMocks
    private MailService mailService;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Ignore
    @Test
    public void testMail() throws MessagingException, MailException {

        //Mockito.doNothing().when(mailService).sendMessage("Test Mail", "UUID");
        mailService.sendMessage("Test Mail", "UUID");

    }

}
