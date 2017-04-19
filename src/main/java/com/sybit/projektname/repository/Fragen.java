package com.sybit.projektname.repository;

import com.google.gson.annotations.SerializedName;
import com.sybit.airtable.vo.Attachment;

import java.util.List;

/**
 * Created by fzr on 10.04.17.
 */
public class Fragen {
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

}
