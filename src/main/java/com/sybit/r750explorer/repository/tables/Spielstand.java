/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.r750explorer.repository.tables;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 *
 * @author fzr
 */
public class Spielstand {
      
    @SerializedName("UUID")
    private String uuid;
    @SerializedName("Location")
    private List<String> locationList;
    @SerializedName("Score")
    private String score;
    @SerializedName("Frage")
    private List<String> questionList;
    @SerializedName("Antwort")
    private String userAnswerIndex;
    @SerializedName("Datum")
    private String date;
    
    
    
    /**
     * @return the uuid (Cookie-ID of the user)
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
     * @return the locationList
     */

    /**
     * @return the score
     */
    public String getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(String score) {
        this.score = score;
    }

    /**
     * @return the userAnswerIndex
     */
    public String getUserAnswerIndex() {
        return userAnswerIndex;
    }

    /**
     * @param userAnswerIndex the userAnswerIndex to set
     */
    public void setUserAnswerIndex(String userAnswerIndex) {
        this.userAnswerIndex = userAnswerIndex;
    }

    /**
     * @return the locationList
     */
    public List<String> getLocationList() {
        return locationList;
    }

    /**
     * @param locationList the locationList to set
     */
    public void setLocationList(List<String> locationList) {
        this.locationList = locationList;
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
     * @return the questionList
     */
    public List<String> getQuestionList() {
        return questionList;
    }

    /**
     * @param questionList the questionList to set
     */
    public void setQuestionList(List<String> questionList) {
        this.questionList = questionList;
    }


    
    
    
}
