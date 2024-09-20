package org.northcoders.recordshopapp.ui.addalbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import org.northcoders.recordshopapp.dto.album.post.NewAlbumRequestBody;
import org.northcoders.recordshopapp.ui.mainactivity.MainActivity;
import org.northcoders.recordshopapp.ui.mainactivity.MainActivityViewModel;
import org.northcoders.recordshopapp.util.DataValidation;

import java.util.regex.Pattern;

public class AddNewAlbumClickHandler {

    private NewAlbumRequestBody newAlbumRequestBody;
    private Context context;
    private MainActivityViewModel viewModel;

    public AddNewAlbumClickHandler(NewAlbumRequestBody newAlbumRequestBody, Context context, MainActivityViewModel viewModel) {
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
        boolean isPublisherInvalid = newAlbumRequestBody.getNewAlbumPublisher() != null && !newAlbumRequestBody.getNewAlbumPublisher().isEmpty() && newAlbumRequestBody.getNewAlbumPublisher().isBlank();
        boolean isPriceInvalid = newAlbumRequestBody.getNewAlbumPriceInPences() == null || newAlbumRequestBody.getNewAlbumPriceInPences() < 1;
        boolean isCurrencyInvalid = newAlbumRequestBody.getNewAlbumCurrency() == null;
        boolean isFormatInvalid = newAlbumRequestBody.getNewAlbumCurrency() == null;

        boolean areFieldsInvalid = isTitleInvalid || areArtistsInvalid || areGenresInvalid || isDurationInvalid
                || isImageUrlInvalid || isReleaseYearInvalid || isPublisherInvalid // nullables
                || isPriceInvalid || isCurrencyInvalid || isFormatInvalid;

        if (areFieldsInvalid) {
            Toast.makeText(context, "Invalid field(s)", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(context, MainActivity.class);

        NewAlbumRequestBody validatedNewAlbum = new NewAlbumRequestBody(
                newAlbumRequestBody.getNewAlbumTitle(),
                newAlbumRequestBody.getNewAlbumArtistIds(),
                newAlbumRequestBody.getNewAlbumGenreIds(),
                newAlbumRequestBody.getNewAlbumDurationInSeconds(),
                newAlbumRequestBody.getNewAlbumImageUrl(),
                newAlbumRequestBody.getNewAlbumReleaseYear(),
                newAlbumRequestBody.getNewAlbumPublisher(),
                newAlbumRequestBody.getNewAlbumPriceInPences(),
                newAlbumRequestBody.getNewAlbumCurrency(),
                newAlbumRequestBody.getNewAlbumFormat()
        );

        viewModel.addAlbum(validatedNewAlbum);

        context.startActivity(intent);
    }

    public void onBackButtonClicked(View view) {
        Intent intent = new Intent(context, MainActivity.class);

        context.startActivity(intent);
    }
}
