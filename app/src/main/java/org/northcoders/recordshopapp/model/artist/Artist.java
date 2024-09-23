package org.northcoders.recordshopapp.model.artist;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import org.northcoders.recordshopapp.BR;

import java.util.List;

public class Artist extends BaseObservable {
    @SerializedName(value = "id")
    private Long artistId;
    @SerializedName(value = "fullName")
    private String artistFullName;
    @SerializedName(value = "albums")
    private List<AlbumSummary> artistAlbums;
    @SerializedName(value = "createdDate")
    private String artistCreatedDate;
    @SerializedName(value = "updatedDate")
    private String artistUpdatedDate;

    public Artist() {
    }

    public Artist(Long artistId, String artistFullName, List<AlbumSummary> artistAlbums, String artistCreatedDate, String artistUpdatedDate) {
        this.artistId = artistId;
        this.artistFullName = artistFullName;
        this.artistAlbums = artistAlbums;
        this.artistCreatedDate = artistCreatedDate;
        this.artistUpdatedDate = artistUpdatedDate;
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
    public String getArtistFullName() {
        return artistFullName;
    }

    public void setArtistFullName(String artistFullName) {
        this.artistFullName = artistFullName;
        notifyPropertyChanged(BR.artistFullName);
    }

    @Bindable
    public List<AlbumSummary> getArtistAlbums() {
        return artistAlbums;
    }

    public void setArtistAlbums(List<AlbumSummary> artistAlbums) {
        this.artistAlbums = artistAlbums;
        notifyPropertyChanged(BR.artistAlbums);
    }

    @Bindable
    public String getArtistCreatedDate() {
        return artistCreatedDate;
    }

    public void setArtistCreatedDate(String artistCreatedDate) {
        this.artistCreatedDate = artistCreatedDate;
        notifyPropertyChanged(BR.artistCreatedDate);
    }

    @Bindable
    public String getArtistUpdatedDate() {
        return artistUpdatedDate;
    }

    public void setArtistUpdatedDate(String artistUpdatedDate) {
        this.artistUpdatedDate = artistUpdatedDate;
        notifyPropertyChanged(BR.artistUpdatedDate);
    }
}
