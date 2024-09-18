package org.northcoders.recordshopapp.model.getalbums;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import org.northcoders.recordshopapp.BR;

public class FlattenedGenre extends BaseObservable {

    @SerializedName(value = "id")
    private Long genreId;
    @SerializedName(value = "name")
    private String name;

    public FlattenedGenre() {
    }

    public FlattenedGenre(Long genreId, String name) {
        this.genreId = genreId;
        this.name = name;
    }

    @Bindable
    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
        notifyPropertyChanged(BR.genreId);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}
