package org.northcoders.recordshopapp.ui.mainactivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
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
    private RecyclerView recyclerView;
    private List<Album> albumList;
    private AlbumAdapter albumAdapter;
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;

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

        getAllAlbums();
    }

    private void getAllAlbums() {
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
}