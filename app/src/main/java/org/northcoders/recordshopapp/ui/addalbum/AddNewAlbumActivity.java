package org.northcoders.recordshopapp.ui.addalbum;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import org.northcoders.recordshopapp.R;
import org.northcoders.recordshopapp.databinding.ActivityAddNewAlbumBinding;
import org.northcoders.recordshopapp.model.album.Album;
import org.northcoders.recordshopapp.ui.mainactivity.MainActivityViewModel;

public class AddNewAlbumActivity extends AppCompatActivity {
    private ActivityAddNewAlbumBinding binding;
    private AddNewAlbumClickHandler clickHandler;
    private Album album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_album);

        album = new Album();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_album);

        MainActivityViewModel viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        clickHandler = new AddNewAlbumClickHandler(album, this, viewModel);

        binding.setAlbum(album);

        binding.setClickHandler(clickHandler);

    }

}