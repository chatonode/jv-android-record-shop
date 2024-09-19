package org.northcoders.recordshopapp.model.api.newalbum;

import org.northcoders.recordshopapp.model.BaseResponse;
import org.northcoders.recordshopapp.model.ResponseStatus;
import org.northcoders.recordshopapp.model.album.Album;

import java.util.List;

public class NewAlbumResponse extends BaseResponse<Album> {

    public NewAlbumResponse() {
        super();
    }

    public NewAlbumResponse(String timestamp, ResponseStatus status, String message, Album album) {
        super(timestamp, status, message, album);
    }

}
