package org.northcoders.recordshopapp.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;

import org.northcoders.recordshopapp.dto.error.SingleErrorResponse;
import org.northcoders.recordshopapp.dto.error.ValidationErrorsResponse;
import org.northcoders.recordshopapp.model.album.Album;
import org.northcoders.recordshopapp.dto.album.get.all.GetAlbumsResponse;
import org.northcoders.recordshopapp.dto.album.post.NewAlbumRequestBody;
import org.northcoders.recordshopapp.dto.album.post.NewAlbumResponse;
import org.northcoders.recordshopapp.dto.enums.ApiResponseStatus;
import org.northcoders.recordshopapp.service.AlbumApiService;
import org.northcoders.recordshopapp.service.RetrofitInstanceProvider;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {
    private static final String TAG = AlbumRepository.class.getSimpleName();
    private Application application;
    private final Gson gson;

    private MutableLiveData<List<Album>> allAlbumsData = new MutableLiveData<>();
//    private MutableLiveData<String> errorMessage = new MutableLiveData<>();

    public AlbumRepository(Application application) {
        this.application = application;
        this.gson = new Gson();
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
                    handleErrorResponse(response);

                    return;
                }

                List<Album> albums = response.body().getData();
                allAlbumsData.setValue(albums);

                Log.d(TAG, String.format("%s (%d)", response.body().getMessage(), albums.size()));
            }

            @Override
            public void onFailure(Call<GetAlbumsResponse> call, Throwable t) {
                handleFailure(t);
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
                    handleErrorResponse(response);
                    return;
                }

                Album createdAlbum = response.body().getData();
                String modifiedSuccessMessage = String.format(
                        "%s -> %s",
                        response.body().getMessage(),
                        createdAlbum.getTitle()
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
                handleFailure(t);
            }
        });
    }

//    public MutableLiveData<String> getErrorMessage() {
//        return errorMessage;
//    }

    private void handleFailure(Throwable t) {
        // TODO: Remove it and use errorMessage as live data in VM, Activity, and UI
        Toast.makeText(
                application.getApplicationContext(),
                "Connection Failure",
                Toast.LENGTH_SHORT
        ).show();

//        errorMessage.setValue("Connection Failure");

        Log.e(TAG, t.getMessage(), t);
    }

    private void handleErrorResponse(Response<?> response) {
        try (ResponseBody responseBody = response.errorBody()) {
            if (response.code() == 400) {

                String errorsBody = responseBody.string();

                ValidationErrorsResponse validationErrorsResponse = gson.fromJson(errorsBody, ValidationErrorsResponse.class);

                int numberOfInvalidFields = validationErrorsResponse.getError().size();
                String modifiedErrorMessage = validationErrorsResponse.getError().get(0).getReason()
                        + ((validationErrorsResponse.getError().size() > 1)
                        ? ", and " + (numberOfInvalidFields - 1) + " more..."
                        : "");

                // TODO: Remove it and use errorMessage as live data in VM, Activity, and UI
                Toast.makeText(
                        application.getApplicationContext(),
                        modifiedErrorMessage,
                        Toast.LENGTH_SHORT
                ).show();

//                errorMessage.setValue(modifiedErrorMessage);

                Log.e(TAG, modifiedErrorMessage);

                return;
            }

            // Else

            String errorBody = responseBody.string();
            SingleErrorResponse singleErrorResponse = gson.fromJson(errorBody, SingleErrorResponse.class);

            // TODO: Remove it and use errorMessage as live data in VM, Activity, and UI
            Toast.makeText(
                    application.getApplicationContext(),
                    singleErrorResponse.getMessage(),
                    Toast.LENGTH_SHORT
            ).show();

//            errorMessage.setValue(singleErrorResponse.getMessage());

            Log.e(TAG, singleErrorResponse.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "Error parsing error response: " + e.getMessage(), e);
        }
    }
}
