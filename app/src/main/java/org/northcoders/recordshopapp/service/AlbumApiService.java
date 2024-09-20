package org.northcoders.recordshopapp.service;

import org.northcoders.recordshopapp.dto.album.get.all.GetAlbumsResponse;
import org.northcoders.recordshopapp.dto.album.post.NewAlbumRequestBody;
import org.northcoders.recordshopapp.dto.album.post.NewAlbumResponse;

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
