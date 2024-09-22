package org.northcoders.recordshopapp.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import org.northcoders.recordshopapp.model.album.Album;
import org.northcoders.recordshopapp.dto.album.get.all.GetAlbumsResponse;
import org.northcoders.recordshopapp.dto.album.post.NewAlbumRequestBody;
import org.northcoders.recordshopapp.dto.album.post.NewAlbumResponse;
import org.northcoders.recordshopapp.service.AlbumApiService;
import org.northcoders.recordshopapp.service.RetrofitInstanceProvider;
import org.northcoders.recordshopapp.util.ErrorResponseHandler;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {
    private static final String TAG = AlbumRepository.class.getSimpleName();
    private Application application;
    private ErrorResponseHandler errorResponseHandler;

    private MutableLiveData<List<Album>> allAlbumsData = new MutableLiveData<>();
//    private MutableLiveData<String> errorMessage = new MutableLiveData<>();

    public AlbumRepository(Application application) {
        this.application = application;
        this.errorResponseHandler = new ErrorResponseHandler();
    }

    public MutableLiveData<List<Album>> getAllAlbums() {
//        errorMessage.setValue("");

        AlbumApiService apiService = RetrofitInstanceProvider.getService();
        Call<GetAlbumsResponse> call = apiService.getAllAlbums();

        call.enqueue(new Callback<GetAlbumsResponse>() {
            @Override
            public void onResponse(Call<GetAlbumsResponse> call, Response<GetAlbumsResponse> response) {
                boolean isErrorResponse = !response.isSuccessful() && response.body() == null;

                if (isErrorResponse) {
                    errorResponseHandler.handleErrorResponse(response);

                    return;
                }

                List<Album> albums = response.body().getData();
                allAlbumsData.setValue(albums);

                Log.d(TAG, String.format("%s (%d)", response.body().getMessage(), albums.size()));
            }

            @Override
            public void onFailure(Call<GetAlbumsResponse> call, Throwable t) {
                errorResponseHandler.handleFailure(t);
            }
        });

        return allAlbumsData;
    }

    public void postNewAlbum(NewAlbumRequestBody albumRequestBody) {
//        errorMessage.setValue("");

        AlbumApiService apiService = RetrofitInstanceProvider.getService();
        Call<NewAlbumResponse> call = apiService.postAlbum(albumRequestBody);

        call.enqueue(new Callback<NewAlbumResponse>() {
            @Override
            public void onResponse(Call<NewAlbumResponse> call, Response<NewAlbumResponse> response) {
                boolean isErrorResponse = !response.isSuccessful() && response.body() == null;

                if (isErrorResponse) {
                    errorResponseHandler.handleErrorResponse(response);
                    return;
                }

                Album createdAlbum = response.body().getData();
                String modifiedSuccessMessage = String.format(
                        "%s -> %s",
                        response.body().getMessage(),
                        createdAlbum.getAlbumTitle()
                );

                // TODO: Remove it and use albumsData as live data in VM, Activity, and UI
                Toast.makeText(
                        application.getApplicationContext(),
                        modifiedSuccessMessage,
                        Toast.LENGTH_SHORT
                ).show();

                Log.d(TAG, modifiedSuccessMessage);
            }

            @Override
            public void onFailure(Call<NewAlbumResponse> call, Throwable t) {
                errorResponseHandler.handleFailure(t);
            }
        });
    }

//    public MutableLiveData<String> getErrorMessage() {
//        return errorMessage;
//    }


}
