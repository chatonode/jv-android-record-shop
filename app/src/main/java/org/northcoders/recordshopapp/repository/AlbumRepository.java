package org.northcoders.recordshopapp.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import org.northcoders.recordshopapp.model.album.Album;
import org.northcoders.recordshopapp.dto.album.get.all.GetAlbumsResponse;
import org.northcoders.recordshopapp.dto.album.post.NewAlbumRequestBody;
import org.northcoders.recordshopapp.dto.album.post.NewAlbumResponse;
import org.northcoders.recordshopapp.dto.enums.ApiResponseStatus;
import org.northcoders.recordshopapp.service.AlbumApiService;
import org.northcoders.recordshopapp.service.RetrofitInstanceProvider;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {
    private MutableLiveData<List<Album>> allAlbumsData = new MutableLiveData<>();
    private Application application;

    public AlbumRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Album>> getAllAlbums() {
        AlbumApiService apiService = RetrofitInstanceProvider.getService();
        Call<GetAlbumsResponse> call = apiService.getAllAlbums();

        call.enqueue(new Callback<GetAlbumsResponse>() {
            @Override
            public void onResponse(Call<GetAlbumsResponse> call, Response<GetAlbumsResponse> response) {
//                if (Objects.equals(response.body().getMessage(), ResponseStatus.ERROR.name())) {
//                    Log.e(
//                            String.format(
//                                    "%s | %s",
//                                    response.body().getStatus(),
//                                    response.body().getMessage()
//                            ),
//                            Objects.requireNonNull(response.body().getMessage())
//                    );
//                } else if (Objects.equals(response.body().getMessage(), ResponseStatus.SUCCESS.name())) {
                List<Album> albums = response.body().getData();
                allAlbumsData.setValue(albums);

                Log.i(
                        response.body().getStatus().name(),
                        Objects.requireNonNull(response.body().getMessage())
                );

                return;
//                }

            }

            @Override
            public void onFailure(Call<GetAlbumsResponse> call, Throwable t) {
                Toast.makeText(
                        application.getApplicationContext(),
                        String.format("Failure on connecting into the api: %s", t.getMessage()),
                        Toast.LENGTH_SHORT
                ).show();

                Log.e("GET /album", Objects.requireNonNull(t.getMessage()));
                Log.e("EXTRA INFO1", Objects.requireNonNull(String.valueOf(t)));
                Log.e("EXTRA INFO2", Objects.requireNonNull(String.valueOf(t.getCause())));

            }
        });

        return allAlbumsData;
    }

    public void postNewAlbum(NewAlbumRequestBody albumRequestBody) {
        AlbumApiService apiService = RetrofitInstanceProvider.getService();
        Call<NewAlbumResponse> call = apiService.postAlbum(albumRequestBody);

        call.enqueue(new Callback<NewAlbumResponse>() {
            @Override
            public void onResponse(Call<NewAlbumResponse> call, Response<NewAlbumResponse> response) {
                if (!response.isSuccessful()
                        || response.body() == null
                        || response.message().equals(ApiResponseStatus.ERROR.name())
                ) {

                    Toast.makeText(
                            application.getApplicationContext(),
                            String.format("Failure on adding an album: %s", response.message()),
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                }

                Log.d(AlbumRepository.class.getSimpleName(), "Album Created Response: " + response.body().getData());


                Album createdAlbum = response.body().getData();
                Toast.makeText(
                        application.getApplicationContext(),
                        String.format("Album %s added to the database!", createdAlbum.getId()),
                        Toast.LENGTH_SHORT
                ).show();

                Log.i(
                        response.body().getStatus().name(),
                        Objects.requireNonNull(response.body().getMessage())
                );
            }

            @Override
            public void onFailure(Call<NewAlbumResponse> call, Throwable t) {
                Toast.makeText(
                        application.getApplicationContext(),
                        String.format("Failure on connecting into the api: %s", t.getMessage()),
                        Toast.LENGTH_SHORT
                ).show();

                Log.e("POST /album", Objects.requireNonNull(t.getMessage()));

                Log.e("EXTRA INFO1", Objects.requireNonNull(String.valueOf(t)));
                Log.e("EXTRA INFO2", Objects.requireNonNull(String.valueOf(t.getCause())));
            }
        });
    }
}
