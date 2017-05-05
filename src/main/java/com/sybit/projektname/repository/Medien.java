package com.sybit.projektname.repository;


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
    @SerializedName("Attachements")
    private List<Attachment> attachements;
    @SerializedName("Link")
    private String link;
    @SerializedName("Quelle")
    private String quelle;
}
