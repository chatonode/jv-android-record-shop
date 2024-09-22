package org.northcoders.recordshopapp.model.error;

import com.google.gson.annotations.SerializedName;

public class ValidationErrorSummary {
    @SerializedName(value = "field")
    private String field;
    @SerializedName(value = "reason")
    private String reason;

    public ValidationErrorSummary(String field, String reason) {
        this.field = field;
        this.reason = reason;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
