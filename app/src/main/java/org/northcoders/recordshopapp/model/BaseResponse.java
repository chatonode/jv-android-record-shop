package org.northcoders.recordshopapp.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import org.northcoders.recordshopapp.BR;

public abstract class BaseResponse<T> extends BaseObservable {
    @SerializedName(value = "timestamp")
    private String timestamp;
    @SerializedName(value = "status")
    private ResponseStatus status;
    @SerializedName(value = "message")
    private String message;
    @SerializedName(value = "data")
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(String timestamp, ResponseStatus status, String message, T data) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.data = data;
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
    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
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

    @Bindable
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
        notifyPropertyChanged(BR.data);
    }
}
