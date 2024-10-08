package org.northcoders.recordshopapp.ui.album.add;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import org.northcoders.recordshopapp.dto.album.post.NewAlbumRequestBody;
import org.northcoders.recordshopapp.ui.album.AlbumActivity;
import org.northcoders.recordshopapp.ui.album.AlbumActivityViewModel;
import org.northcoders.recordshopapp.util.DataValidation;

import java.util.regex.Pattern;

public class AddNewAlbumClickHandler {
    private final static String TAG = AddNewAlbumClickHandler.class.getSimpleName();

    private NewAlbumRequestBody newAlbumRequestBody;
    private Context context;
    private AlbumActivityViewModel viewModel;

    public AddNewAlbumClickHandler(NewAlbumRequestBody newAlbumRequestBody, Context context, AlbumActivityViewModel viewModel) {
        this.newAlbumRequestBody = newAlbumRequestBody;
        this.context = context;
        this.viewModel = viewModel;
    }

    public void onSubmitButtonClicked(View view) {
        boolean isTitleInvalid = newAlbumRequestBody.getNewAlbumTitle() == null || newAlbumRequestBody.getNewAlbumTitle().isBlank();
        boolean areArtistsInvalid = newAlbumRequestBody.getNewAlbumArtistIds() == null || newAlbumRequestBody.getNewAlbumArtistIds().isEmpty();
        boolean areGenresInvalid = newAlbumRequestBody.getNewAlbumGenreIds() == null || newAlbumRequestBody.getNewAlbumGenreIds().isEmpty();
        boolean isDurationInvalid = newAlbumRequestBody.getNewAlbumDurationInSeconds() == null || newAlbumRequestBody.getNewAlbumDurationInSeconds() < 30;
        boolean isImageUrlInvalid = newAlbumRequestBody.getNewAlbumImageUrl() != null && !newAlbumRequestBody.getNewAlbumImageUrl().isBlank() && !Pattern.matches(DataValidation.URL_REGEX, newAlbumRequestBody.getNewAlbumImageUrl());
        boolean isReleaseYearInvalid = newAlbumRequestBody.getNewAlbumReleaseYear() != null && newAlbumRequestBody.getNewAlbumReleaseYear() < 1900;
        boolean isPublisherInvalid = newAlbumRequestBody.getNewAlbumPublisher() != null && !newAlbumRequestBody.getNewAlbumPublisher().isEmpty() && newAlbumRequestBody.getNewAlbumPublisher().trim().isEmpty();
        boolean isPriceInvalid = newAlbumRequestBody.getNewAlbumPriceInPences() == null || newAlbumRequestBody.getNewAlbumPriceInPences() < 1;
        boolean isCurrencyInvalid = newAlbumRequestBody.getNewAlbumCurrency() == null;
        boolean isFormatInvalid = newAlbumRequestBody.getNewAlbumFormat() == null;

//        Log.e(TAG, "isTitleInvalid: " + isTitleInvalid);
//        Log.e(TAG, "areArtistsInvalid: " + areArtistsInvalid);
//        Log.e(TAG, "areGenresInvalid: " + areGenresInvalid);
//        Log.e(TAG, "isDurationInvalid: " + isDurationInvalid);
//        Log.e(TAG, "isImageUrlInvalid: " + isImageUrlInvalid);
//        Log.e(TAG, "isReleaseYearInvalid: " + isReleaseYearInvalid);
//        Log.e(TAG, "isPublisherInvalid: " + isPublisherInvalid);
//        Log.e(TAG, "isPriceInvalid: " + isPriceInvalid);
//        Log.e(TAG, "isCurrencyInvalid: " + isCurrencyInvalid);
//        Log.e(TAG, "isFormatInvalid: " + isFormatInvalid);

        boolean areFieldsInvalid = isTitleInvalid || areArtistsInvalid || areGenresInvalid || isDurationInvalid
                || isImageUrlInvalid || isReleaseYearInvalid || isPublisherInvalid // nullables
                || isPriceInvalid || isCurrencyInvalid || isFormatInvalid;

        if (areFieldsInvalid) {
            Toast.makeText(context, "Invalid field(s)", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(context, AlbumActivity.class);

        NewAlbumRequestBody validatedNewAlbum = new NewAlbumRequestBody(
                newAlbumRequestBody.getNewAlbumTitle(),
                newAlbumRequestBody.getNewAlbumArtistIds(),
                newAlbumRequestBody.getNewAlbumGenreIds(),
                newAlbumRequestBody.getNewAlbumDurationInSeconds(),
                newAlbumRequestBody.getNewAlbumImageUrl().isEmpty()
                        ? null
                        : newAlbumRequestBody.getNewAlbumImageUrl(),
                newAlbumRequestBody.getNewAlbumReleaseYear(),
                newAlbumRequestBody.getNewAlbumPublisher().isEmpty()
                        ? null
                        : newAlbumRequestBody.getNewAlbumPublisher(),
                newAlbumRequestBody.getNewAlbumPriceInPences(),
                newAlbumRequestBody.getNewAlbumCurrency(),
                newAlbumRequestBody.getNewAlbumFormat()
        );

        viewModel.addAlbum(validatedNewAlbum);

        context.startActivity(intent);
    }

    public void onBackButtonClicked(View view) {
        Intent intent = new Intent(context, AlbumActivity.class);

        context.startActivity(intent);
    }
}
