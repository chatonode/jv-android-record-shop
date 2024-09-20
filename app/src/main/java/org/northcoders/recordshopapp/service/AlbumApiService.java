package org.northcoders.recordshopapp.service;

import org.northcoders.recordshopapp.model.api.getalbums.GetAlbumsResponse;
import org.northcoders.recordshopapp.model.api.newalbum.NewAlbumRequestBody;
import org.northcoders.recordshopapp.model.api.newalbum.NewAlbumResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AlbumApiService {
    @GET("api/v1/album")
    Call<GetAlbumsResponse> getAllAlbums();

    @POST("api/v1/album")
    Call<NewAlbumResponse> postAlbum(@Body NewAlbumRequestBody albumRequestBody);
}
