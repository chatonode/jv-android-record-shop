package org.northcoders.recordshopapp.repository;

public interface Callback<ResponseDTO> {
    void onSuccess(ResponseDTO response);
    void onError(String errorMessage);
}
