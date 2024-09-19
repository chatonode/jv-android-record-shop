package org.northcoders.recordshopapp.model.api.getalbums;

import org.northcoders.recordshopapp.model.api.BaseResponse;
import org.northcoders.recordshopapp.model.enums.api.ResponseStatus;
import org.northcoders.recordshopapp.model.album.Album;

import java.util.List;

public class GetAlbumsResponse extends BaseResponse<List<Album>> {

    public GetAlbumsResponse() {
        super();
    }

    public GetAlbumsResponse(String timestamp, ResponseStatus status, String message, List<Album> albums) {
        super(timestamp, status, message, albums);
    }

}
