package org.northcoders.recordshopapp.dto.error;

import org.northcoders.recordshopapp.dto.ErrorResponse;
import org.northcoders.recordshopapp.dto.enums.ApiResponseStatus;
import org.northcoders.recordshopapp.model.error.ValidationErrorSummary;

import java.util.List;

public class ValidationErrorsResponse extends ErrorResponse<List<ValidationErrorSummary>> {

    public ValidationErrorsResponse(String timestamp, ApiResponseStatus status, String message, List<ValidationErrorSummary> validationErrorSummaries) {
        super(timestamp, status, message, validationErrorSummaries);
    }
}
