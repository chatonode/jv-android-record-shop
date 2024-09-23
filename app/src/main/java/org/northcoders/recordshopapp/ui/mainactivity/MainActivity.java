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

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();

    private List<Album> albumList;

    private AlbumAdapter albumAdapter;
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;
    private MainActivityClickHandler clickHandler;
    private SearchView searchView;

    private RecyclerView recyclerView;
    private Observer<List<Album>> allAlbumsObserver;
    private Observer<List<Album>> filteredAlbumsObserver;

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

        loadAllAlbums();
        searchView = findViewById(R.id.searchView_album_filter);
        setupSearchView();
    }

    private void setupSearchView() {
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
                    loadFilteredAlbums(newText.toLowerCase());
                } else {
                    // If search is cleared, show all albums
                    Log.d(TAG, "Loaded all albums from search view onChange");
                    loadAllAlbums();
                }

                return true;
            }
        });
    }


    private void loadAllAlbums() {
        if (allAlbumsObserver == null) {
            allAlbumsObserver = new Observer<List<Album>>() {
                @Override
                public void onChanged(List<Album> albumsFromLiveData) {
                    albumList = albumsFromLiveData;

                    Log.d(TAG, "all result size: " + albumsFromLiveData.size());

                    displayAlbumsInRecyclerView();
                }
            };
        }

        viewModel.getAllAlbums().observe(this, allAlbumsObserver);
    }

    private void displayAlbumsInRecyclerView() {
        recyclerView = binding.albumRecyclerView;
        albumAdapter = new AlbumAdapter(this, albumList);
        recyclerView.setAdapter(albumAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        albumAdapter.notifyDataSetChanged();
    }

    private void loadFilteredAlbums(String query) {
        if (filteredAlbumsObserver == null) {
            // For not creating an observer all the time and re-using it
            filteredAlbumsObserver = new Observer<List<Album>>() {
                @Override
                public void onChanged(List<Album> filteredAlbumsFromLiveData) {
                    Log.d(TAG, "search result size: " + filteredAlbumsFromLiveData.size());

                    if (filteredAlbumsFromLiveData.isEmpty()) {
                        Toast.makeText(MainActivity.this, "No albums found.", Toast.LENGTH_SHORT).show();
                    }
                    albumAdapter.setFilteredList(filteredAlbumsFromLiveData);

                    albumAdapter.notifyDataSetChanged();

                }
            };
        }

        viewModel.getFilteredAlbums(query).observe(this, filteredAlbumsObserver);
    }
}