/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.config;

import com.sybit.r750explorer.repository.tables.Location;
import com.sybit.r750explorer.service.ScoreService;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

/**
 *
 * Cookie Interceptor to manage User UUID. 
 * Checks if Cookie exists. If not new Cookie is created.
 *
 * @author fzr
 */
@Component
public class CookieInterceptor implements HandlerInterceptor {

    @Autowired
    ScoreService scoreService;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3) {

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView model) {
        javax.servlet.http.Cookie cookie = WebUtils.getCookie(request, "UUID");
        if (cookie != null) {

        } else {
            String uuid = UUID.randomUUID().toString();
            javax.servlet.http.Cookie ncookie = new javax.servlet.http.Cookie("UUID", uuid);
            response.addCookie(ncookie);

            scoreService.newSpielstandEntry(uuid, null, null, "Startwert", Float.valueOf(100));
        }

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) {

        return true;
    }

}
