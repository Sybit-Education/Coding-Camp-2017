package com.sybit.r750explorer.repository;

import com.sybit.airtable.vo.Attachment;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by fzr on 10.04.17.
 */
public class Location {

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



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Attachment> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Attachment> photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getFragen() {
        return fragen;
    }

    public void setFragen(List<String> fragen) {
        this.fragen = fragen;
    }

    public List<String> getMedien() {
        return medien;
    }

    public void setMedien(List<String> medien) {
        this.medien = medien;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeHinweis() {
        return codeHinweis;
    }

    public void setCodeHinweis(String codeHinweis) {
        this.codeHinweis = codeHinweis;
    }

    public List<Attachment> getCodeHintPhoto() {
        return codeHintPhoto;
    }

    public void setCodeHintPhoto(List<Attachment> codeHintPhoto) {
        this.codeHintPhoto = codeHintPhoto;
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
}
