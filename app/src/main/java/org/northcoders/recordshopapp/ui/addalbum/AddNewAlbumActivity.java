package org.northcoders.recordshopapp.ui.addalbum;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import org.northcoders.recordshopapp.R;
import org.northcoders.recordshopapp.databinding.ActivityAddNewAlbumBinding;
import org.northcoders.recordshopapp.model.album.Album;
import org.northcoders.recordshopapp.model.album.FlattenedArtist;
import org.northcoders.recordshopapp.model.album.FlattenedGenre;
import org.northcoders.recordshopapp.model.enums.album.Currency;
import org.northcoders.recordshopapp.model.enums.album.Format;
import org.northcoders.recordshopapp.ui.mainactivity.MainActivityViewModel;

import java.util.ArrayList;

public class AddNewAlbumActivity extends AppCompatActivity {
    private ActivityAddNewAlbumBinding binding;
    private AddNewAlbumClickHandler clickHandler;
    private Album album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_album);

        album = new Album();
        album.setTitle("");
        // TODO: Fix Artists
        album.setArtists(new ArrayList<FlattenedArtist>(){{
            add(new FlattenedArtist(1L, "Elton John"));
        }});
        // TODO: Fix Genres
        album.setGenres(new ArrayList<FlattenedGenre>(){{
            add(new FlattenedGenre(1L, "ROCK"));
        }});
        album.setDurationInSeconds(1);
        album.setImageUrl("");
        album.setReleaseYear(1968);
        album.setPublisher("");
        album.setPriceInPences(1);
        album.setCurrency(Currency.GBP);
//        album.setQuantityInStock(0);
        album.setFormat(Format.Vinyl);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_album);

        Log.d(AddNewAlbumActivity.class.getSimpleName(), "Album Initialised: " + album.getTitle());

        MainActivityViewModel viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        clickHandler = new AddNewAlbumClickHandler(album, this, viewModel);

        binding.setAlbum(album);

        binding.setClickHandler(clickHandler);

    }

}