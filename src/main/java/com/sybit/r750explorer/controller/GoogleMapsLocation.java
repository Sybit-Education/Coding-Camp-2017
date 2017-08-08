/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.controller;

import com.sybit.r750explorer.repository.tables.Location;
import java.io.Serializable;

/**
 * Wrapper-Class for GoogleMaps locations requested by AJAX.
 * 
 * @author ssr
 */
public class GoogleMapsLocation implements Serializable {
    
    private String id;

    private String name;

    private String status;

    private String slug;

    private String photo;
    
    private String thumbnail;

    private String description;

    private String geoLat;

    private String geoLng;

    private String geoZoom;
    
    private boolean visited;


    /**
     * 
     */
    public GoogleMapsLocation() {
        
    }
     
    /**
     * 
     * @param loc 
     */
    public GoogleMapsLocation(Location loc) {
        
        this.id = loc.getId();
        this.name = loc.getName();
        this.status = loc.getStatus();
        this.slug = loc.getSlug();
        if(loc.getPhoto().size() > 0) {
            this.photo = loc.getPhoto().get(0).getUrl();
            this.thumbnail = loc.getPhoto().get(0).getThumbnails().get("large").getUrl();
        }
        this.description = loc.getDescription();
        this.geoLat = loc.getGeoLat();
        this.geoLng = loc.getGeoLng();
        this.geoZoom = loc.getGeoZoom();
        this.visited = loc.isVisited();   
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGeoLat() {
        return geoLat;
    }

    public void setGeoLat(String geoLat) {
        this.geoLat = geoLat;
    }

    public String getGeoLng() {
        return geoLng;
    }

    public void setGeoLng(String geoLng) {
        this.geoLng = geoLng;
    }

    public String getGeoZoom() {
        return geoZoom;
    }

    public void setGeoZoom(String geoZoom) {
        this.geoZoom = geoZoom;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    
}
