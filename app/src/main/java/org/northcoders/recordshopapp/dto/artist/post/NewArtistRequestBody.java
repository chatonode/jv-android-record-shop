package org.northcoders.recordshopapp.dto.artist.post;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import org.northcoders.recordshopapp.BR;

import java.util.List;

public class NewArtistRequestBody extends BaseObservable {
    @SerializedName(value = "fullName")
    private String newArtistFullName;
    @SerializedName(value = "albumIds")
    private List<Long> newArtistAlbumIds;

    public NewArtistRequestBody() {
    }

    public NewArtistRequestBody(String newArtistFullName, List<Long> newArtistAlbumIds) {
        this.newArtistFullName = newArtistFullName;
        this.newArtistAlbumIds = newArtistAlbumIds;
    }

    @Bindable
    public String getNewArtistFullName() {
        return newArtistFullName;
    }

    public void setNewArtistFullName(String newArtistFullName) {
        this.newArtistFullName = newArtistFullName;
        notifyPropertyChanged(BR.newArtistFullName);
    }

    @Bindable
    public List<Long> getNewArtistAlbumIds() {
        return newArtistAlbumIds;
    }

    public void setNewArtistAlbumIds(List<Long> newArtistAlbumIds) {
        this.newArtistAlbumIds = newArtistAlbumIds;
        notifyPropertyChanged(BR.newArtistAlbumIds);
    }
}
