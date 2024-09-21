package org.northcoders.recordshopapp.dto;

import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import org.northcoders.recordshopapp.BR;
import org.northcoders.recordshopapp.dto.enums.ApiResponseStatus;

public class ErrorResponse<T> extends BaseResponse {
    @SerializedName(value = "error")
    private T error;

    public ErrorResponse(String timestamp, ApiResponseStatus status, String message, T error) {
        super(timestamp, status, message);
        this.error = error;
    }

    @Bindable
    public T getError() {
        return error;
    }

    public void setError(T error) {
        this.error = error;
        notifyPropertyChanged(BR.error);
    }
}
