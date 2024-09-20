package org.northcoders.recordshopapp.dto.album.post;

import org.northcoders.recordshopapp.dto.BaseResponse;
import org.northcoders.recordshopapp.dto.SuccessResponse;
import org.northcoders.recordshopapp.dto.enums.ApiResponseStatus;
import org.northcoders.recordshopapp.model.album.Album;

import java.util.List;

public class NewAlbumResponse extends SuccessResponse<Album> {

    public NewAlbumResponse(String timestamp, ApiResponseStatus status, String message, Album album) {
        super(timestamp, status, message, album);
    }

}
