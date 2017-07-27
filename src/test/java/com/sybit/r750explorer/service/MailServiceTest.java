/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.service;

import com.sybit.r750explorer.exception.MailException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;

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
