/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.service;

import com.sybit.r750explorer.repository.SponsorenRepository;
import com.sybit.r750explorer.repository.tables.Sponsor;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fzr
 */
@Service
public class SponsorenService {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SponsorenRepository sponsorenRepository;

    // Die Methode soll alle Sponsoren als Liste zurückgeben
    public List<Sponsor> getSponsorenList() {
        log.debug("--> getSponsorenList");

        // Es werden die Sponsoren aus dem Repository genommen
        List<Sponsor> sponsoren = sponsorenRepository.getSponsoren();
        List<Sponsor> sponsorenAktiv = new ArrayList<>();

        for (Sponsor s : sponsoren) {
            sponsorenAktiv.add(s);
        }

        //throw new MethodNotFoundException("Methode nicht implementiert");
        return sponsorenAktiv;
    }
}
