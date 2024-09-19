package org.northcoders.recordshopapp.model.api.newalbum;

import org.northcoders.recordshopapp.model.api.BaseResponse;
import org.northcoders.recordshopapp.model.enums.api.ResponseStatus;
import org.northcoders.recordshopapp.model.album.Album;

public class NewAlbumResponse extends BaseResponse<Album> {

    public NewAlbumResponse() {
        super();
    }

    public NewAlbumResponse(String timestamp, ResponseStatus status, String message, Album album) {
        super(timestamp, status, message, album);
    }

}
