package org.northcoders.recordshopapp.model.get_albums;

import androidx.databinding.BaseObservable;

import com.google.gson.annotations.SerializedName;

public class FlattenedGenre extends BaseObservable {

    @SerializedName(value = "id")
    private Long id;
    @SerializedName(value = "name")
    private String name;

    public FlattenedGenre() {
    }

    public FlattenedGenre(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
