package org.northcoders.recordshopapp.service;

import org.northcoders.recordshopapp.model.get_albums.GetAlbumsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AlbumApiService {
    @GET("")
    Call<GetAlbumsResponse> getAllAlbums();
}
