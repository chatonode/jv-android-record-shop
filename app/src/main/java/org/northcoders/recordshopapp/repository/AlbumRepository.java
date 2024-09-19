package org.northcoders.recordshopapp.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import org.northcoders.recordshopapp.model.ResponseStatus;
import org.northcoders.recordshopapp.model.getalbums.Album;
import org.northcoders.recordshopapp.model.getalbums.GetAlbumsResponse;
import org.northcoders.recordshopapp.service.AlbumApiService;
import org.northcoders.recordshopapp.service.RetrofitInstance;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {
    private MutableLiveData<List<Album>> mutableLiveAlbumsData = new MutableLiveData<>();
    private Application application;

    public AlbumRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Album>> getMutableLiveAlbumsData() {
        AlbumApiService apiService = RetrofitInstance.getService();
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
                List<Album> albums = response.body().getAlbums();
                mutableLiveAlbumsData.setValue(albums);

                Log.i(
                        response.body().getStatus().name(),
                        Objects.requireNonNull(response.body().getMessage())
                );

                return;
//                }

            }

            @Override
            public void onFailure(Call<GetAlbumsResponse> call, Throwable t) {
//                try {
//                    Log.e("TRY/CATCH", call.execute().body().getMessage());
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
                Log.e("GET /albums", Objects.requireNonNull(t.getMessage()));

                Log.e("EXTRA INFO1", Objects.requireNonNull(String.valueOf(t)));
                Log.e("EXTRA INFO2", Objects.requireNonNull(String.valueOf(t.getCause())));

            }
        });

        return mutableLiveAlbumsData;
    }
}
