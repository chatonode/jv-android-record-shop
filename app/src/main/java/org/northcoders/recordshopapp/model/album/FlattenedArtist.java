package org.northcoders.recordshopapp.model.album;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import org.northcoders.recordshopapp.BR;

public class FlattenedArtist extends BaseObservable {

    @SerializedName(value = "id")
    private Long artistId;
    @SerializedName(value = "fullName")
    private String fullName;

    public FlattenedArtist() {
    }

    public FlattenedArtist(Long artistId, String fullName) {
        this.artistId = artistId;
        this.fullName = fullName;
    }

    @Bindable
    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
        notifyPropertyChanged(BR.artistId);
    }

    @Bindable
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
        notifyPropertyChanged(BR.fullName);
    }
}
