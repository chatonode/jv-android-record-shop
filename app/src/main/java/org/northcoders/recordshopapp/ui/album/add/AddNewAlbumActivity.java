package org.northcoders.recordshopapp.ui.album.add;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import org.northcoders.recordshopapp.R;
import org.northcoders.recordshopapp.databinding.ActivityAddNewAlbumBinding;
import org.northcoders.recordshopapp.dto.album.post.NewAlbumRequestBody;
import org.northcoders.recordshopapp.model.artist.Artist;
import org.northcoders.recordshopapp.model.enums.Currency;
import org.northcoders.recordshopapp.model.enums.Format;
import org.northcoders.recordshopapp.ui.mainactivity.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class AddNewAlbumActivity extends AppCompatActivity {
    private static final String TAG = AddNewAlbumActivity.class.getSimpleName();

    private ActivityAddNewAlbumBinding binding;
    private AddNewAlbumClickHandler clickHandler;
    private NewAlbumRequestBody newAlbumFields;
    private AddNewAlbumViewModel addAlbumViewModel;
    private List<Artist> artistList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_album);

        initialiseAlbumWithFields();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_album);

        MainActivityViewModel mainViewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        addAlbumViewModel = new ViewModelProvider(this)
                .get(AddNewAlbumViewModel.class);

        clickHandler = new AddNewAlbumClickHandler(newAlbumFields, this, mainViewModel);

        binding.setAlbumInputs(newAlbumFields);

        binding.setClickHandler(clickHandler);

        getAllArtists();
    }

    private void initialiseAlbumWithFields() {
        newAlbumFields = new NewAlbumRequestBody();
        newAlbumFields.setNewAlbumTitle("");
        // TODO: Make it dynamic!
        newAlbumFields.setNewAlbumArtistIds(new ArrayList<Long>() {{
            add(1L);
        }});
        // TODO: Make it dynamic!
        newAlbumFields.setNewAlbumGenreIds(new ArrayList<Long>() {{
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

        Log.d(AddNewAlbumActivity.class.getSimpleName(), "Album Initialised");

    }


    private void getAllArtists() {
        addAlbumViewModel.getAllArtists().observe(this, new Observer<List<Artist>>() {
            @Override
            public void onChanged(List<Artist> artistsFromLiveData) {
                artistList = artistsFromLiveData;

                Log.e(TAG, "artistList.size(): " + artistList.size());

            }
        });
    }

    //    public void populateArtistChips(List<String> artistNames) {
//        ChipGroup chipGroup = findViewById(R.id.chipGroup_album_field_artists);
//        chipGroup.animate();
//        chipGroup.removeAllViews(); // Clear existing chips
//
//        for (String artistName : artistNames) {
//            Chip chip = new Chip(context);
//            chip.setText(artistName);
//            chip.setCheckable(true);
//
//            // Set click listener to handle chip selection
//            chip.setOnCheckedChangeListener((buttonView, isChecked) -> {
//                if (isChecked) {
//                    newAlbumRequestBody.getNewAlbumArtistIds().add(/* get artist ID */);
//                } else {
//                    newAlbumRequestBody.getNewAlbumArtistIds().remove(/* get artist ID */);
//                }
//            });
//
//            chipGroup.addView(chip);
//        }
//    }
}