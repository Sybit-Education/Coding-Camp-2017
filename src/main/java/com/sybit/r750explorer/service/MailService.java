/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.service;

import com.sybit.r750explorer.exception.MailException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Service;

/**
 * Service to send Mails.
 * 
 * @author fzr
 */
@Service
public class MailService {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    private MailSender mailSender;

    private Properties prop;

    /**
     * Set the Mail Sender.
     * 
     * @param mailSender 
     */
    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    /**
     * Send message by mail.
     * 
     * @param messageBody Message body.
     * @param uuid Cookie-ID of the user
     * @throws MailException 
     */
    public void sendMessage(String messageBody, String uuid) throws MailException {

        log.debug("--> sendMessage. UUID: " + uuid);

        ClassLoader classLoader = getClass().getClassLoader();
        File propertiesFile = new File(classLoader.getResource("gmail.properties").getFile());

        if (propertiesExist(propertiesFile)) {

            String username = prop.getProperty("E-MAIL");
            String password = prop.getProperty("PASSWORD");

            Properties gMailProps = new Properties();
            gMailProps.put("mail.smtp.auth", "true");
            gMailProps.put("mail.smtp.starttls.enable", "true");
            gMailProps.put("mail.smtp.host", "smtp.gmail.com");
            gMailProps.put("mail.smtp.port", "587");

            Session session = Session.getInstance(gMailProps,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("r750explorer@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse("r750explorer@gmail.com"));
                message.setSubject("R750 Explorer Mail. UUID: " + uuid);
                message.setText("Message from the R750Explorer.\nUser uuid: " + uuid + "\nMessage Content: \n\n" + messageBody);

                Transport.send(message);

                log.debug("Message send.");

            } catch (MessagingException e) {
                throw new MailException(e);
            }
        } else {

            throw new MailException("Mail Properties not defined!");
        }
    }

    /**
     * Check for mail properties.
     * 
     * @param propertiesFile
     * @return 
     */
    private boolean propertiesExist(File propertiesFile) {

        log.debug("--> propertiesExist");

        Properties prop = new Properties();
        InputStream input = null;
        boolean exists = false;

        try {
            input = new FileInputStream(propertiesFile);

            prop.load(input);

            exists = prop.getProperty("E-MAIL") != null
                    && prop.getProperty("PASSWORD") != null;
            if (exists) {
                this.prop = prop;
            }
        } catch (IOException ex) {
            log.error("PropertiesFile corrupted!" + ex);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    log.error("Cant close Input!");
                }
            }
        }

        return exists;
    }
}
