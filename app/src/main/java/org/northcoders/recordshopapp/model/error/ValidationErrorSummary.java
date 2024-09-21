package org.northcoders.recordshopapp.model.error;

import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

public class ValidationErrorSummary {
    @SerializedName(value = "defaultMessage")
    private String message;
    @SerializedName(value = "privateObjectName")
    private String objectName;

    public ValidationErrorSummary(String message, String objectName) {
        this.message = message;
        this.objectName = objectName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }
}
