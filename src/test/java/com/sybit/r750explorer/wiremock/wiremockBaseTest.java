/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 *
 * Starts the Playback server for every Test File. If you want to record comment
 * out the Marked Lines and start the record batch under resources.
 *
 * @author fzr
 */
public class wiremockBaseTest {

    private static WireMockServer wireMockServer;

    @BeforeClass
    public static void startWiremock() {

        //wireMockServer = new WireMockServer(options().port(8095)); //Comment out for record
        //wireMockServer.start(); //Comment out for record

    }

    @AfterClass
    public static void stopWiremock() {

        //wireMockServer.stop(); //Comment out for record
    }

}
