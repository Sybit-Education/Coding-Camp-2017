/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.controller;

import com.sybit.r750explorer.repository.tables.Sponsor;
import com.sybit.r750explorer.service.SponsorenService;
import java.util.List;
import java.util.Map;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ssr
 */
@Controller
public class SponsorenController {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SponsorenService sponsorenService;

    /**
     * Controller method to get 'impressum' page.
     *
     * @param model Model to add data of Sponsoren
     * @return
     */
    @RequestMapping("/sponsoren")
    public String sponsoren(Map<String, Object> model) {

        log.debug("--> Sponsoren");

        // TODO: Liste aller Sponsoren erstellen (aus dem Service) 
        // Parameter wie name und die Liste dem Model übergeben
        List<Sponsor> sponsoren = sponsorenService.getSponsorenList();
        model.put("sponsoren", sponsoren);

        return "sponsoren";
    }
}
