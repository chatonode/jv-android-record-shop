package org.northcoders.recordshopapp.service;

import org.northcoders.recordshopapp.dto.artist.get.all.GetArtistsResponse;
import org.northcoders.recordshopapp.dto.artist.post.NewArtistRequestBody;
import org.northcoders.recordshopapp.dto.artist.post.NewArtistResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ArtistApiService {
    @GET("api/v1/artist")
    Call<GetArtistsResponse> getAllArtists();

    @POST("api/v1/artist")
    Call<NewArtistResponse> postArtist(@Body NewArtistRequestBody artistRequestBody);
}
