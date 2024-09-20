package org.northcoders.recordshopapp.ui.addalbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import org.northcoders.recordshopapp.model.album.Album;
import org.northcoders.recordshopapp.ui.mainactivity.MainActivity;
import org.northcoders.recordshopapp.ui.mainactivity.MainActivityViewModel;
import org.northcoders.recordshopapp.util.DataValidation;

import java.util.regex.Pattern;

public class AddNewAlbumClickHandler {

    private Album album;
    private Context context;
    private MainActivityViewModel viewModel;

    public AddNewAlbumClickHandler(Album album, Context context, MainActivityViewModel viewModel) {
        this.album = album;
        this.context = context;
        this.viewModel = viewModel;
    }

    public void onSubmitButtonClicked(View view) {
        boolean isTitleInvalid = album.getTitle() == null || album.getTitle().isBlank();
        boolean areArtistsInvalid = album.getArtists() == null || album.getArtists().isEmpty();
        boolean areGenresInvalid = album.getGenres() == null || album.getGenres().isEmpty();
        boolean isDurationInvalid = album.getDurationInSeconds() == null || album.getDurationInSeconds() < 1;
        boolean isImageUrlInvalid = album.getImageUrl() == null || Pattern.matches(DataValidation.URL_REGEX, album.getImageUrl());
        boolean isReleaseYearInvalid = album.getReleaseYear() == null || album.getReleaseYear() < 1900;
        boolean isPublisherInvalid = album.getPublisher() == null || album.getPublisher().isBlank();
        boolean isPriceInvalid = album.getPriceInPences() == null || album.getPriceInPences() < 1;
        boolean isCurrencyInvalid = album.getCurrency() == null;
        boolean isFormatInvalid = album.getFormat() == null;

        boolean areRequiredFieldsInvalid = isTitleInvalid || areArtistsInvalid || areGenresInvalid || isDurationInvalid || isPriceInvalid || isCurrencyInvalid || isFormatInvalid;

        if (areRequiredFieldsInvalid) {
            Toast.makeText(context, "Invalid field(s)", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(context, MainActivity.class);

        Album newAlbum = new Album(
                null, // id | TODO: Disable it while creating
                album.getTitle(),
                album.getArtists(),
                album.getGenres(),
                album.getDurationInSeconds(),
                album.getImageUrl(),
                album.getReleaseYear(),
                album.getPublisher(),
                album.getPriceInPences(),
                album.getCurrency(),
                null, // quantityInStock | TODO: Disable it while creating
                album.getFormat(),
                null, // createdDate | TODO: Disable it while creating
                null // updatedDate | TODO: Disable it while creating
        );

        viewModel.addAlbum(newAlbum);

        context.startActivity(intent);
    }

    public void onBackButtonClicked(View view) {
        Intent intent = new Intent(context, MainActivity.class);

        context.startActivity(intent);
    }
}
