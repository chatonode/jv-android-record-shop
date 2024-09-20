package org.northcoders.recordshopapp.dto;

import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import org.northcoders.recordshopapp.BR;
import org.northcoders.recordshopapp.dto.enums.ApiResponseStatus;

public abstract class SuccessResponse<T> extends BaseResponse {
    @SerializedName(value = "data")
    private T data;

    public SuccessResponse(String timestamp, ApiResponseStatus status, String message, T data) {
        super(timestamp, status, message);
        this.data = data;
    }

    @Bindable
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
        notifyPropertyChanged(BR.data);
    }
}
