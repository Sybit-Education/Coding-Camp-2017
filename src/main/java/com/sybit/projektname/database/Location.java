package com.sybit.projektname.database;


import com.google.gson.annotations.SerializedName;
import com.sybit.airtable.vo.Attachment;

import java.util.List;

/**
 * Created by fzr on 10.04.17.
 */
public class Location {

    @SerializedName("Name")
    private String name;
    @SerializedName("Foto")
    private List<Attachment> photo;
    @SerializedName("Beschreibung")
    private String description;
    @SerializedName("Geo-Koordinaten")
    private String geoKoordinates;
    @SerializedName("Fragen")
    private List<String> fragen;
    @SerializedName("Medien")
    private List<String> medien;
    @SerializedName("Code")
    private String code;
    @SerializedName("Code Hinweis")
    private String codeHinweis;
    @SerializedName("Code Hinweis Foto")
    private List<Attachment> codeHintPhoto;
    @SerializedName("Events")
    private String events;

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

    public String getGeoKoordinates() {
        return geoKoordinates;
    }

    public void setGeoKoordinates(String geoKoordinates) {
        this.geoKoordinates = geoKoordinates;
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

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }
}
