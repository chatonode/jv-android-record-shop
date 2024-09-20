package org.northcoders.recordshopapp.model.album;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import org.northcoders.recordshopapp.BR;

public class GenreSummary extends BaseObservable {

    @SerializedName(value = "id")
    private Long genreSummaryId;
    @SerializedName(value = "name")
    private String genreSummaryName;

    public GenreSummary() {
    }

    public GenreSummary(Long genreSummaryId, String genreSummaryName) {
        this.genreSummaryId = genreSummaryId;
        this.genreSummaryName = genreSummaryName;
    }

    @Bindable
    public Long getGenreSummaryId() {
        return genreSummaryId;
    }

    public void setGenreSummaryId(Long genreSummaryId) {
        this.genreSummaryId = genreSummaryId;
        notifyPropertyChanged(BR.genreSummaryId);
    }

    @Bindable
    public String getGenreSummaryName() {
        return genreSummaryName;
    }

    public void setGenreSummaryName(String genreSummaryName) {
        this.genreSummaryName = genreSummaryName;
        notifyPropertyChanged(BR.genreSummaryName);
    }
}
