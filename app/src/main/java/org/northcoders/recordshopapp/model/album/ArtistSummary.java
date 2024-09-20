package org.northcoders.recordshopapp.model.album;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import org.northcoders.recordshopapp.BR;

public class ArtistSummary extends BaseObservable {

    @SerializedName(value = "id")
    private Long artistSummaryId;
    @SerializedName(value = "fullName")
    private String artistSummaryFullName;

    public ArtistSummary() {
    }

    public ArtistSummary(Long artistSummaryId, String artistSummaryFullName) {
        this.artistSummaryId = artistSummaryId;
        this.artistSummaryFullName = artistSummaryFullName;
    }

    @Bindable
    public Long getArtistSummaryId() {
        return artistSummaryId;
    }

    public void setArtistSummaryId(Long artistSummaryId) {
        this.artistSummaryId = artistSummaryId;
        notifyPropertyChanged(BR.artistSummaryId);
    }

    @Bindable
    public String getArtistSummaryFullName() {
        return artistSummaryFullName;
    }

    public void setArtistSummaryFullName(String artistSummaryFullName) {
        this.artistSummaryFullName = artistSummaryFullName;
        notifyPropertyChanged(BR.artistSummaryFullName);
    }
}
