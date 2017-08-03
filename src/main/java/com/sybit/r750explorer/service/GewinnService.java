/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.service;

import com.sybit.r750explorer.repository.GewinnRepository;
import com.sybit.r750explorer.repository.tables.Gewinn;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Schüler
 */
@Service
public class GewinnService {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GewinnRepository gewinnRepository;

    public List<Gewinn> getGewinnList() {

        log.debug("--> getGewinnList");

        return gewinnRepository.getAll();
    }

    public List<Gewinn> getGewinnOfMonth() {
        List<Gewinn> gewOfMonth = new ArrayList<>();;
        try {
            log.debug("--> getGewinnOfMonth");

            LocalDateTime currentdate = LocalDateTime.now();
            DateTimeFormatter df = DateTimeFormatter.ISO_LOCAL_DATE;
            String formatdate = currentdate.format(df);
            formatdate = formatdate.substring(0, 7);

            for (Gewinn gw : gewinnRepository.getAll()) {
                String date = gw.getVerlosungsmonat();
                date = date.substring(0, 7);

                if (date.equalsIgnoreCase(formatdate)) {
                    gewOfMonth.add(gw);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace(  );
        }
        return gewOfMonth;
    }
}
