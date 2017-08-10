/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.repository.tables;

import com.google.gson.annotations.SerializedName;
import com.sybit.airtable.vo.Attachment;
import java.util.List;

/**
 *
 * @author fzr
 */
public class Sponsor {

    @SerializedName("Name")
    private String name;
    @SerializedName("Status")
    private String status;
    @SerializedName("Beschreibung")
    private String description;
    @SerializedName("Logo")
    private List<Attachment> logo;
    @SerializedName("Webseite")
    private String link;

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
     * @return the logo
     */
    public List<Attachment> getLogo() {
        return logo;
    }

    /**
     * @param logo the logo to set
     */
    public void setLogo(List<Attachment> logo) {
        this.logo = logo;
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
}
