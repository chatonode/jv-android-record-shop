package org.northcoders.recordshopapp.model.getalbums;

import androidx.databinding.BaseObservable;

import com.google.gson.annotations.SerializedName;

public class FlattenedArtist extends BaseObservable {

    @SerializedName(value = "id")
    private Long id;
    @SerializedName(value = "fullName")
    private String fullName;

    public FlattenedArtist() {
    }

    public FlattenedArtist(Long id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
