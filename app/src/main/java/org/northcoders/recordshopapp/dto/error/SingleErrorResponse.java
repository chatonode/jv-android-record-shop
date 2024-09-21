package org.northcoders.recordshopapp.dto.error;

import org.northcoders.recordshopapp.dto.ErrorResponse;
import org.northcoders.recordshopapp.dto.enums.ApiResponseStatus;

public class SingleErrorResponse extends ErrorResponse<String> {

    public SingleErrorResponse(String timestamp, ApiResponseStatus status, String message, String error) {
        super(timestamp, status, message, error);
    }
}
