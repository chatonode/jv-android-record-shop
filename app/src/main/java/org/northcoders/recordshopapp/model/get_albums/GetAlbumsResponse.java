package org.northcoders.recordshopapp.model.get_albums;

import androidx.databinding.BaseObservable;

import com.google.gson.annotations.SerializedName;

import org.northcoders.recordshopapp.model.ResponseStatus;

import java.util.Date;
import java.util.List;

public class GetAlbumsResponse extends BaseObservable {

    @SerializedName(value = "timestamp")
    private Date timestamp;
    @SerializedName(value = "status")
    private ResponseStatus status;
    @SerializedName(value = "message")
    private String message;
    @SerializedName(value = "data")
    private List<Album> albums;

    public GetAlbumsResponse() {
    }

    public GetAlbumsResponse(Date timestamp, ResponseStatus status, String message, List<Album> albums) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.albums = albums;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
