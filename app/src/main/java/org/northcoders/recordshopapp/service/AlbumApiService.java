package org.northcoders.recordshopapp.service;

import org.northcoders.recordshopapp.model.api.getalbums.GetAlbumsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AlbumApiService {
    @GET("api/v1/album")
    Call<GetAlbumsResponse> getAllAlbums();
}
