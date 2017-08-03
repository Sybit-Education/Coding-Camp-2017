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
 * @author Schüler
 */
public class Gewinn {
       
    @SerializedName("Name")
    private String name;
    @SerializedName("Status")
    private String status;
    @SerializedName("Sponsor")
    private List<String> sponsor;
    @SerializedName("Bemerkung")
    private String bemerkung;
    @SerializedName("Foto")
    private List<Attachment> foto;
    @SerializedName("Verlosungsmonat")
    private String verlosungsmonat;

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
     * @return the sponsor
     */
    public List<String> getSponsor() {
        return sponsor;
    }

    /**
     * @param sponsor the sponsor to set
     */
    public void setSponsor(List<String> sponsor) {
        this.sponsor = sponsor;
    }

    /**
     * @return the bemerkung
     */
    public String getBemerkung() {
        return bemerkung;
    }

    /**
     * @param bemerkung the bemerkung to set
     */
    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    /**
     * @return the foto
     */
    public List<Attachment> getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(List<Attachment> foto) {
        this.foto = foto;
    }

    /**
     * @return the verlosungsmonat
     */
    public String getVerlosungsmonat() {
        return verlosungsmonat;
    }

    /**
     * @param verlosungsmonat the verlosungsmonat to set
     */
    public void setVerlosungsmonat(String verlosungsmonat) {
        this.verlosungsmonat = verlosungsmonat;
    }


    
    
    
}
