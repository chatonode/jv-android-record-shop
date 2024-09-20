package org.northcoders.recordshopapp.dto;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import org.northcoders.recordshopapp.BR;
import org.northcoders.recordshopapp.dto.enums.ApiResponseStatus;

public abstract class BaseResponse extends BaseObservable {
    @SerializedName(value = "timestamp")
    private String timestamp;
    @SerializedName(value = "status")
    private ApiResponseStatus status;
    @SerializedName(value = "message")
    private String message;

    public BaseResponse(String timestamp, ApiResponseStatus status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }

    @Bindable
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
        notifyPropertyChanged(BR.timestamp);
    }

    @Bindable
    public ApiResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ApiResponseStatus status) {
        this.status = status;
        notifyPropertyChanged(BR.status);
    }

    @Bindable
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        notifyPropertyChanged(BR.message);
    }

}
