package org.northcoders.recordshopapp.service;

import org.northcoders.recordshopapp.model.getalbums.GetAlbumsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AlbumApiService {
    @GET("album")
    Call<GetAlbumsResponse> getAllAlbums();
}
