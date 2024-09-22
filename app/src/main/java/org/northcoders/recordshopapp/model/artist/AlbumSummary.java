package org.northcoders.recordshopapp.model.artist;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import org.northcoders.recordshopapp.BR;

public class AlbumSummary extends BaseObservable {
    @SerializedName(value = "id")
    private Long albumSummaryId;
    @SerializedName(value = "title")
    private String albumSummaryTitle;

    public AlbumSummary() {
    }

    public AlbumSummary(Long albumSummaryId, String albumSummaryTitle) {
        this.albumSummaryId = albumSummaryId;
        this.albumSummaryTitle = albumSummaryTitle;
    }

    @Bindable
    public Long getAlbumSummaryId() {
        return albumSummaryId;
    }

    public void setAlbumSummaryId(Long albumSummaryId) {
        this.albumSummaryId = albumSummaryId;
        notifyPropertyChanged(BR.albumSummaryId);
    }

    @Bindable
    public String getAlbumSummaryTitle() {
        return albumSummaryTitle;
    }

    public void setAlbumSummaryTitle(String albumSummaryTitle) {
        this.albumSummaryTitle = albumSummaryTitle;
        notifyPropertyChanged(BR.albumSummaryTitle);
    }
}
