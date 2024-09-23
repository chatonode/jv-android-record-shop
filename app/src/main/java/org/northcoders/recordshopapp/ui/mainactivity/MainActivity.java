package org.northcoders.recordshopapp.ui.mainactivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.northcoders.recordshopapp.R;
import org.northcoders.recordshopapp.databinding.ActivityMainBinding;
import org.northcoders.recordshopapp.model.album.Album;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();

    private List<Album> albumList;

    private AlbumAdapter albumAdapter;
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;
    private MainActivityClickHandler clickHandler;

    private RecyclerView recyclerView;
//    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Debugging
//        Application application = new Application();
//        AlbumRepository albumRepository = new AlbumRepository(application);
//        albumRepository.getMutableLiveAlbumsData();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        clickHandler = new MainActivityClickHandler(this);
        binding.setClickHandler(clickHandler);

        observeAllAlbums();

//        observeErrorMessage();

//        searchView = findViewById(R.id.searchView_album_filter);
//        searchView.clearFocus();
        setSearchViewListeners();
    }

    private void setSearchViewListeners() {
        SearchView searchView = binding.searchViewAlbumFilter;
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Default handler
                return false;
                // For custom handling:
                // return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!newText.isBlank()) {
                    observeFilteredAlbums(newText.toLowerCase());
                } else {
                    // If search is cleared, show all albums
                    albumAdapter.setFilteredList(albumList);
                }

                return true;
            }
        });
    }


    private void observeAllAlbums() {
        viewModel.getAllAlbums().observe(this, new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albumsFromLiveData) {
                albumList = albumsFromLiveData;

                displayAlbumsInRecyclerView();
            }
        });
    }

    private void displayAlbumsInRecyclerView() {
        recyclerView = binding.albumRecyclerView;
        albumAdapter = new AlbumAdapter(this, albumList);
        recyclerView.setAdapter(albumAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        albumAdapter.notifyDataSetChanged();
    }

    private void observeFilteredAlbums(String query) {
        viewModel.getFilteredAlbums(query).observe(this, new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> filteredAlbumsFromLiveData) {
                Log.d(TAG, query + " result size: " + filteredAlbumsFromLiveData.size());

                // Check if results are empty and update the adapter
                if (filteredAlbumsFromLiveData.isEmpty()) {
                    Toast.makeText(MainActivity.this, "No albums found.", Toast.LENGTH_SHORT).show();
                }
                albumAdapter.setFilteredList(filteredAlbumsFromLiveData);

                albumAdapter.notifyDataSetChanged();

            }
        });
    }


//    private void observeErrorMessage() {
//        viewModel.getErrorMessage().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String errorMessage) {
//                Toast.makeText(
//                        getApplicationContext(),
//                        errorMessage,
//                        Toast.LENGTH_SHORT
//                ).show();
//            }
//        });
//    }
}