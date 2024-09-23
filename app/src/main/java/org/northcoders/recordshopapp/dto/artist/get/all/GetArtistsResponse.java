package org.northcoders.recordshopapp.dto.artist.get.all;

import org.northcoders.recordshopapp.dto.SuccessResponse;
import org.northcoders.recordshopapp.dto.enums.ApiResponseStatus;
import org.northcoders.recordshopapp.model.artist.Artist;

import java.util.List;

public class GetArtistsResponse extends SuccessResponse<List<Artist>> {

    public GetArtistsResponse(String timestamp, ApiResponseStatus status, String message, List<Artist> data) {
        super(timestamp, status, message, data);
    }
}
