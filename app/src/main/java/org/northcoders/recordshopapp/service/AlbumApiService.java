package org.northcoders.recordshopapp.service;

import org.northcoders.recordshopapp.dto.album.get.all.GetAlbumsResponse;
import org.northcoders.recordshopapp.dto.album.post.NewAlbumRequestBody;
import org.northcoders.recordshopapp.dto.album.post.NewAlbumResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AlbumApiService {
    @GET("api/v1/album")
    Call<GetAlbumsResponse> getAllAlbums();

    @GET("api/v1/album")
    Call<GetAlbumsResponse> getFilteredAlbums(
            @Query("title") String title,
            @Query("year") Integer year
//            @Query("genre") String genre,
//            @Query("format") String format
    );

    @POST("api/v1/album")
    Call<NewAlbumResponse> postAlbum(@Body NewAlbumRequestBody albumRequestBody);

}
