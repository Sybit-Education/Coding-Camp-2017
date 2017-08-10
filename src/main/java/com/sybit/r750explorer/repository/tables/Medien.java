package com.sybit.r750explorer.repository.tables;


import com.google.gson.annotations.SerializedName;
import com.sybit.airtable.vo.Attachment;

import java.util.List;

/**
 * Created by fzr on 10.04.17.
 */
public class Medien {

    @SerializedName("Überschrift")
    private String ueberschrift;
    @SerializedName("Location")
    private List<String> location;
    @SerializedName("Typ")
    private String type;
    @SerializedName("Text")
    private String text;
    @SerializedName("Attachments")
    private List<Attachment> attachements;
    @SerializedName("Link")
    private String link;
    @SerializedName("Quelle")
    private String quelle;
    @SerializedName("Sortierung")
    private String sort;

    /**
     * @return the ueberschrift
     */
    public String getUeberschrift() {
        return ueberschrift;
    }

    /**
     * @param ueberschrift the ueberschrift to set
     */
    public void setUeberschrift(String ueberschrift) {
        this.ueberschrift = ueberschrift;
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

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the attachements
     */
    public List<Attachment> getAttachements() {
        return attachements;
    }

    /**
     * @param attachements the attachements to set
     */
    public void setAttachements(List<Attachment> attachements) {
        this.attachements = attachements;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return the quelle
     */
    public String getQuelle() {
        return quelle;
    }

    /**
     * @param quelle the quelle to set
     */
    public void setQuelle(String quelle) {
        this.quelle = quelle;
    }

    /**
     * @return the sort
     */
    public String getSort() {
        return sort;
    }

    /**
     * @param sort the sort to set
     */
    public void setSort(String sort) {
        this.sort = sort;
    }

   
}
