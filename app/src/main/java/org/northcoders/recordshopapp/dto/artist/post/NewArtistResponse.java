package org.northcoders.recordshopapp.dto.artist.post;

import org.northcoders.recordshopapp.dto.SuccessResponse;
import org.northcoders.recordshopapp.dto.enums.ApiResponseStatus;

public class NewArtistResponse extends SuccessResponse<Artist> {

    public NewArtistResponse(String timestamp, ApiResponseStatus status, String message, Artist data) {
        super(timestamp, status, message, data);
    }
}
