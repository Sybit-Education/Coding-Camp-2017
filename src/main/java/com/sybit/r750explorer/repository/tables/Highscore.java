/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.repository.tables;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author fzr
 */
public class Highscore {

    private String id;
    @SerializedName("Name")
    private String nickname;
    @SerializedName("E-Mail")
    private String email;
    @SerializedName("Punkte")
    private Float score;
    @SerializedName("Datum")
    private String date;
    @SerializedName("UUID")
    private String uuid;
    @SerializedName("Vorname")
    private String vorname;
    @SerializedName("Nachname")
    private String nachname;
    
    private int badge;
    
    
    

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the score
     */
    public Float getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(Float score) {
        this.score = score;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid the uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    /**
     * @return the badge
     */
    public int getBadge() {
        return badge;
    }

    /**
     * @param badge the badge to set
     */
    public void setBadge(int badge) {
        this.badge = badge;
    }

}
