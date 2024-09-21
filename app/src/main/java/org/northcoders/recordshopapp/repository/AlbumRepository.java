package org.northcoders.recordshopapp.repository;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import org.northcoders.recordshopapp.dto.BaseResponse;
import org.northcoders.recordshopapp.dto.error.SingleErrorResponse;
import org.northcoders.recordshopapp.dto.error.ValidationErrorsResponse;
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
    private static final String TAG = AlbumRepository.class.getSimpleName();

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
                List<Album> albums = response.body().getData();
                allAlbumsData.setValue(albums);

                Log.d(TAG, String.format("%s (%d)", response.body().getMessage(), albums.size()));

                return;
            }

            @Override
            public void onFailure(Call<GetAlbumsResponse> call, Throwable t) {
                Toast.makeText(
                        application.getApplicationContext(),
                        "Connection Failure",
                        Toast.LENGTH_SHORT
                ).show();

                Log.e(TAG, t.getMessage());

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


                Album createdAlbum = response.body().getData();
                String modifiedSuccessMessage = String.format("%s -> %s", response.body().getMessage(), createdAlbum.getTitle());

                Toast.makeText(
                        application.getApplicationContext(),
                        modifiedSuccessMessage,
                        Toast.LENGTH_SHORT
                ).show();

                Log.d(TAG, modifiedSuccessMessage);
            }

            @Override
            public void onFailure(Call<NewAlbumResponse> call, Throwable t) {
                Toast.makeText(
                        application.getApplicationContext(),
                        "Connection Failure",
                        Toast.LENGTH_SHORT
                ).show();

                Log.e(TAG, t.getMessage());
            }
        });
    }
}


// Alternatife with logging & toasting:

//package org.northcoders.recordshopapp.repository;
//
//import android.app.Application;
//import android.util.Log;
//import android.widget.Toast;
//
//import androidx.lifecycle.MutableLiveData;
//
//import org.northcoders.recordshopapp.dto.BaseResponse;
//import org.northcoders.recordshopapp.dto.ErrorResponse;
//import org.northcoders.recordshopapp.dto.error.SingleErrorResponse;
//import org.northcoders.recordshopapp.dto.error.ValidationErrorsResponse;
//import org.northcoders.recordshopapp.model.album.Album;
//import org.northcoders.recordshopapp.dto.album.get.all.GetAlbumsResponse;
//import org.northcoders.recordshopapp.dto.album.post.NewAlbumRequestBody;
//import org.northcoders.recordshopapp.dto.album.post.NewAlbumResponse;
//import org.northcoders.recordshopapp.dto.enums.ApiResponseStatus;
//import org.northcoders.recordshopapp.service.AlbumApiService;
//import org.northcoders.recordshopapp.service.RetrofitInstanceProvider;
//
//import java.util.List;
//import java.util.Objects;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class AlbumRepository {
//    private static final String TAG = AlbumRepository.class.getSimpleName();
//    private MutableLiveData<List<Album>> allAlbumsData = new MutableLiveData<>();
//    private Application application;
//
//    public AlbumRepository(Application application) {
//        this.application = application;
//    }
//
//    public MutableLiveData<List<Album>> getAllAlbums() {
//        AlbumApiService apiService = RetrofitInstanceProvider.getService();
//        Call<BaseResponse> call = apiService.getAllAlbums();
//
//        call.enqueue(new Callback<BaseResponse>() {
//            @Override
//            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
//
//                if (response.body() == null) {
//                    Log.e(TAG, "Unable to retrieve the response from the API!");
//                    return;
//                }
//
//                boolean isErrorResponse = !response.isSuccessful() || response.body().getStatus().equals(ApiResponseStatus.ERROR);
//
//                if (isErrorResponse) {
//
//                    // Unhandled errors
//                    SingleErrorResponse singleErrorResponse = (SingleErrorResponse) response.body();
//
//                    Toast.makeText(
//                            application.getApplicationContext(),
//                            singleErrorResponse.getMessage(),
//                            Toast.LENGTH_SHORT
//                    ).show();
//
//                    Log.e(TAG, singleErrorResponse.getMessage());
//
//                    return;
//                }
//
//                BaseResponse body = response.body();
//                GetAlbumsResponse successResponse = (GetAlbumsResponse) body;
//
//                List<Album> albums = successResponse.getData();
//                allAlbumsData.setValue(albums);
//
//                Log.i(TAG, String.format("%s (%d)", successResponse.getMessage(), albums.size()));
//            }
//
//            @Override
//            public void onFailure(Call<BaseResponse> call, Throwable t) {
//                Toast.makeText(
//                        application.getApplicationContext(),
//                        "API Connection Failure",
//                        Toast.LENGTH_SHORT
//                ).show();
//
//                Log.e(TAG, t.getMessage());
//            }
//        });
//
//        return allAlbumsData;
//    }
//
//    public void postNewAlbum(NewAlbumRequestBody albumRequestBody) {
//        AlbumApiService apiService = RetrofitInstanceProvider.getService();
//        Call<BaseResponse> call = apiService.postAlbum(albumRequestBody);
//
//        call.enqueue(new Callback<BaseResponse>() {
//            @Override
//            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
//
//
//                if (response.body() == null) {
//                    Log.e(TAG, "Unable to retrieve the response from the API!");
//                    return;
//                }
//
//                boolean isErrorResponse = !response.isSuccessful() || response.body().getStatus().equals(ApiResponseStatus.ERROR);
//
//                if (isErrorResponse) {
//
//                    if (response.code() == 400) {
//                        ValidationErrorsResponse validationErrorsResponse = (ValidationErrorsResponse) response.body();
//
//                        String modifiedErrorMessage = validationErrorsResponse.getError().get(0).getMessage()
//                                + ((validationErrorsResponse.getError().size() > 1) ? " and more..." : "");
//
//                        Toast.makeText(
//                                application.getApplicationContext(),
//                                modifiedErrorMessage,
//                                Toast.LENGTH_SHORT
//                        ).show();
//
//                        Log.e(TAG, modifiedErrorMessage);
//
//                        return;
//                    }
//
//
//                    // Unhandled errors
//                    SingleErrorResponse singleErrorResponse = (SingleErrorResponse) response.body();
//
//                    Toast.makeText(
//                            application.getApplicationContext(),
//                            singleErrorResponse.getMessage(),
//                            Toast.LENGTH_SHORT
//                    ).show();
//
//                    Log.e(TAG, singleErrorResponse.getMessage());
//
//                    return;
//                }
//
//                NewAlbumResponse successResponse = (NewAlbumResponse) response.body();
//                Album createdAlbum = successResponse.getData();
//
//                String modifiedSuccessMessage = String.format("%s -> (%s)", successResponse.getMessage(), createdAlbum.getTitle());
//
//                Toast.makeText(
//                        application.getApplicationContext(),
//                        modifiedSuccessMessage,
//                        Toast.LENGTH_SHORT
//                ).show();
//
//                Log.i(TAG, modifiedSuccessMessage);
//
//            }
//
//            @Override
//            public void onFailure(Call<BaseResponse> call, Throwable t) {
//                Toast.makeText(
//                        application.getApplicationContext(),
//                        "API Connection Failure",
//                        Toast.LENGTH_SHORT
//                ).show();
//
//                Log.e(TAG, t.getMessage());
//            }
//        });
//    }
//}
