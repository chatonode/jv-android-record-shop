package org.northcoders.recordshopapp.dto.album.get.all;

import org.northcoders.recordshopapp.dto.BaseResponse;
import org.northcoders.recordshopapp.dto.SuccessResponse;
import org.northcoders.recordshopapp.dto.enums.ApiResponseStatus;
import org.northcoders.recordshopapp.model.album.Album;

import java.util.List;

public class GetAlbumsResponse extends SuccessResponse<List<Album>> {

    public GetAlbumsResponse(String timestamp, ApiResponseStatus status, String message, List<Album> albums) {
        super(timestamp, status, message, albums);
    }

}
