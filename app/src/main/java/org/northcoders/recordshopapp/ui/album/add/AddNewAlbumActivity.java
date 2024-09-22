package org.northcoders.recordshopapp.ui.album.add;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import org.northcoders.recordshopapp.R;
import org.northcoders.recordshopapp.databinding.ActivityAddNewAlbumBinding;
import org.northcoders.recordshopapp.dto.album.post.NewAlbumRequestBody;
import org.northcoders.recordshopapp.model.enums.Currency;
import org.northcoders.recordshopapp.model.enums.Format;
import org.northcoders.recordshopapp.ui.mainactivity.MainActivityViewModel;

import java.util.ArrayList;

public class AddNewAlbumActivity extends AppCompatActivity {
    private ActivityAddNewAlbumBinding binding;
    private AddNewAlbumClickHandler clickHandler;
    private NewAlbumRequestBody newAlbumFields;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_album);

        newAlbumFields = new NewAlbumRequestBody();
        newAlbumFields.setNewAlbumTitle("");
        // TODO: Make it dynamic!
        newAlbumFields.setNewAlbumArtistIds(new ArrayList<Long>(){{
            add(1L);
        }});
        // TODO: Make it dynamic!
        newAlbumFields.setNewAlbumGenreIds(new ArrayList<Long>(){{
            add(1L);
        }});
        newAlbumFields.setNewAlbumDurationInSeconds(1);
        newAlbumFields.setNewAlbumImageUrl("");
        newAlbumFields.setNewAlbumReleaseYear(1968);
        newAlbumFields.setNewAlbumPublisher("");
        newAlbumFields.setNewAlbumPriceInPences(1);
        // TODO: Make it dynamic!
        newAlbumFields.setNewAlbumCurrency(Currency.GBP);
        // TODO: Make it dynamic!
        newAlbumFields.setNewAlbumFormat(Format.Vinyl);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_album);

        Log.d(AddNewAlbumActivity.class.getSimpleName(), "Album Initialised");

        MainActivityViewModel viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        clickHandler = new AddNewAlbumClickHandler(newAlbumFields, this, viewModel);

        binding.setAlbumInputs(newAlbumFields);

        binding.setClickHandler(clickHandler);

    }

}