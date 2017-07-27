package com.sybit.r750explorer.repository.tables;

import com.google.gson.annotations.SerializedName;
import com.sybit.airtable.vo.Attachment;

import java.util.List;

/**
 * Created by fzr on 10.04.17.
 */
public class Fragen {
    
    private String id;
    @SerializedName("Frage")
    private String frage;
    @SerializedName("Antwort 1")
    private String antwort1;
    @SerializedName("Antwort 2")
    private String antwort2;
    @SerializedName("Antwort 3")
    private String antwort3;
    @SerializedName("Lösung")
    private Float loesung;
    @SerializedName("Lösung Text")
    private String loesungText;
    @SerializedName("Bild")
    private List<Attachment> bild;
    @SerializedName("Location")
    private List<String> location;

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
     * @return the frage
     */
    public String getFrage() {
        return frage;
    }

    /**
     * @param frage the frage to set
     */
    public void setFrage(String frage) {
        this.frage = frage;
    }

    /**
     * @return the antwort1
     */
    public String getAntwort1() {
        return antwort1;
    }

    /**
     * @param antwort1 the antwort1 to set
     */
    public void setAntwort1(String antwort1) {
        this.antwort1 = antwort1;
    }

    /**
     * @return the antwort2
     */
    public String getAntwort2() {
        return antwort2;
    }

    /**
     * @param antwort2 the antwort2 to set
     */
    public void setAntwort2(String antwort2) {
        this.antwort2 = antwort2;
    }

    /**
     * @return the antwort3
     */
    public String getAntwort3() {
        return antwort3;
    }

    /**
     * @param antwort3 the antwort3 to set
     */
    public void setAntwort3(String antwort3) {
        this.antwort3 = antwort3;
    }

    /**
     * @return the loesung
     */
    public Float getLoesung() {
        return loesung;
    }

    /**
     * @param loesung the loesung to set
     */
    public void setLoesung(Float loesung) {
        this.loesung = loesung;
    }

    /**
     * @return the loesungText
     */
    public String getLoesungText() {
        return loesungText;
    }

    /**
     * @param loesungText the loesungText to set
     */
    public void setLoesungText(String loesungText) {
        this.loesungText = loesungText;
    }

    /**
     * @return the bild
     */
    public List<Attachment> getBild() {
        return bild;
    }

    /**
     * @param bild the bild to set
     */
    public void setBild(List<Attachment> bild) {
        this.bild = bild;
    }

    /**
     * @return the location
     */
    public List<String> getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(List<String> location) {
        this.location = location;
    }


    
    
    
}
