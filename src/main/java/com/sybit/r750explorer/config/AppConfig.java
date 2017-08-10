/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Application Configuration.
 * 
 * @author fzr
 */
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {
     
    @Autowired
    CookieInterceptor cookieInterceptor;
     
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(cookieInterceptor);
    }
}
