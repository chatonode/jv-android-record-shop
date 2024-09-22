package org.northcoders.recordshopapp.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import org.northcoders.recordshopapp.dto.artist.get.all.GetArtistsResponse;
import org.northcoders.recordshopapp.dto.artist.post.NewArtistRequestBody;
import org.northcoders.recordshopapp.dto.artist.post.NewArtistResponse;
import org.northcoders.recordshopapp.model.artist.Artist;
import org.northcoders.recordshopapp.service.ArtistApiService;
import org.northcoders.recordshopapp.service.RetrofitInstanceProvider;
import org.northcoders.recordshopapp.util.ErrorResponseHandler;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtistRepository {
    private static final String TAG = ArtistRepository.class.getSimpleName();
    private Application application;
    private ErrorResponseHandler errorResponseHandler;

    private MutableLiveData<List<Artist>> allArtistData = new MutableLiveData<>();
//    private MutableLiveData<String> errorMessage = new MutableLiveData<>();

    public ArtistRepository(Application application) {
        this.application = application;
        this.errorResponseHandler = new ErrorResponseHandler();
    }

    public MutableLiveData<List<Artist>> getAllArtists() {
//        errorMessage.setValue("");

        ArtistApiService apiService = RetrofitInstanceProvider.getService(ArtistApiService.class);
        Call<GetArtistsResponse> call = apiService.getAllArtists();

        call.enqueue(new Callback<GetArtistsResponse>() {
            @Override
            public void onResponse(Call<GetArtistsResponse> call, Response<GetArtistsResponse> response) {
                boolean isErrorResponse = !response.isSuccessful() && response.body() == null;

                if (isErrorResponse) {
                    errorResponseHandler.handleErrorResponse(response);

                    return;
                }

                List<Artist> artists = response.body().getData();
                allArtistData.setValue(artists);

                Log.d(TAG, String.format("%s (%d)", response.body().getMessage(), artists.size()));
            }

            @Override
            public void onFailure(Call<GetArtistsResponse> call, Throwable t) {
                errorResponseHandler.handleFailure(t);
            }
        });

        return allArtistData;
    }

    public void postNewArtist(NewArtistRequestBody artistRequestBody) {
//        errorMessage.setValue("");

        ArtistApiService apiService = RetrofitInstanceProvider.getService(ArtistApiService.class);
        Call<NewArtistResponse> call = apiService.postArtist(artistRequestBody);

        call.enqueue(new Callback<NewArtistResponse>() {
            @Override
            public void onResponse(Call<NewArtistResponse> call, Response<NewArtistResponse> response) {
                boolean isErrorResponse = !response.isSuccessful() && response.body() == null;

                if (isErrorResponse) {
                    errorResponseHandler.handleErrorResponse(response);
                    return;
                }

                Artist createdArtist = response.body().getData();
                String modifiedSuccessMessage = String.format(
                        "%s -> %s",
                        response.body().getMessage(),
                        createdArtist.getArtistFullName()
                );

                // TODO: Remove it and use artistsData as live data in VM, Activity, and UI
                Toast.makeText(
                        application.getApplicationContext(),
                        modifiedSuccessMessage,
                        Toast.LENGTH_SHORT
                ).show();

                Log.d(TAG, modifiedSuccessMessage);
            }

            @Override
            public void onFailure(Call<NewArtistResponse> call, Throwable t) {
                errorResponseHandler.handleFailure(t);
            }
        });
    }

//    public MutableLiveData<String> getErrorMessage() {
//        return errorMessage;
//    }


}
