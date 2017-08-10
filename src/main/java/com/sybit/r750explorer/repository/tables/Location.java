package com.sybit.r750explorer.repository.tables;

import com.sybit.airtable.vo.Attachment;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

/**
 * Created by fzr on 10.04.17.
 */
public class Location {

    private String id;
    @SerializedName("Name")
    private String name;
    @SerializedName("Status")
    private String status;
    @SerializedName("Slug")
    private String slug;
    @SerializedName("Foto")
    private List<Attachment> photo;
    @SerializedName("Beschreibung")
    private String description;
    @SerializedName("Code")
    private String code;
    @SerializedName("Fragen")
    private List<String> fragen;
    @SerializedName("Medien")
    private List<String> medien;
    @SerializedName("Code Hinweis")
    private String codeHinweis;
    @SerializedName("Code Hinweis Foto")
    private List<Attachment> codeHintPhoto;
    @SerializedName("Geo-Lat")
    private String geoLat;
    @SerializedName("Geo-Lng")
    private String geoLng;
    @SerializedName("Geo-Zoom")
    private String geoZoom;
    
    private boolean visited;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the slug
     */
    public String getSlug() {
        return slug;
    }

    /**
     * @param slug the slug to set
     */
    public void setSlug(String slug) {
        this.slug = slug;
    }

    /**
     * @return the photo
     */
    public List<Attachment> getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(List<Attachment> photo) {
        this.photo = photo;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the fragen
     */
    public List<String> getFragen() {
        return fragen;
    }

    /**
     * @param fragen the fragen to set
     */
    public void setFragen(List<String> fragen) {
        this.fragen = fragen;
    }

    /**
     * @return the medien
     */
    public List<String> getMedien() {
        return medien;
    }

    /**
     * @param medien the medien to set
     */
    public void setMedien(List<String> medien) {
        this.medien = medien;
    }

    /**
     * @return the codeHinweis
     */
    public String getCodeHinweis() {
        return codeHinweis;
    }

    /**
     * @param codeHinweis the codeHinweis to set
     */
    public void setCodeHinweis(String codeHinweis) {
        this.codeHinweis = codeHinweis;
    }

    /**
     * @return the codeHintPhoto
     */
    public List<Attachment> getCodeHintPhoto() {
        return codeHintPhoto;
    }

    /**
     * @param codeHintPhoto the codeHintPhoto to set
     */
    public void setCodeHintPhoto(List<Attachment> codeHintPhoto) {
        this.codeHintPhoto = codeHintPhoto;
    }

    /**
     * @return the geoLat
     */
    public String getGeoLat() {
        return geoLat;
    }

    /**
     * @param geoLat the geoLat to set
     */
    public void setGeoLat(String geoLat) {
        this.geoLat = geoLat;
    }

    /**
     * @return the geoLng
     */
    public String getGeoLng() {
        return geoLng;
    }

    /**
     * @param geoLng the geoLng to set
     */
    public void setGeoLng(String geoLng) {
        this.geoLng = geoLng;
    }

    /**
     * @return the geoZoom
     */
    public String getGeoZoom() {
        return geoZoom;
    }

    /**
     * @param geoZoom the geoZoom to set
     */
    public void setGeoZoom(String geoZoom) {
        this.geoZoom = geoZoom;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.status);
        hash = 47 * hash + Objects.hashCode(this.slug);
        hash = 47 * hash + Objects.hashCode(this.description);
        hash = 47 * hash + Objects.hashCode(this.code);
        hash = 47 * hash + Objects.hashCode(this.codeHinweis);
        hash = 47 * hash + Objects.hashCode(this.codeHintPhoto);
        hash = 47 * hash + Objects.hashCode(this.geoLat);
        hash = 47 * hash + Objects.hashCode(this.geoLng);
        hash = 47 * hash + Objects.hashCode(this.geoZoom);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.slug, other.slug)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.codeHinweis, other.codeHinweis)) {
            return false;
        }
        if (!Objects.equals(this.geoLat, other.geoLat)) {
            return false;
        }
        if (!Objects.equals(this.geoLng, other.geoLng)) {
            return false;
        }
        if (!Objects.equals(this.geoZoom, other.geoZoom)) {
            return false;
        }

        return true;
    }
    

}
