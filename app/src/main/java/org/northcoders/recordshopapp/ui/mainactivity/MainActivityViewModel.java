package org.northcoders.recordshopapp.ui.mainactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.northcoders.recordshopapp.model.album.Album;
import org.northcoders.recordshopapp.dto.album.post.NewAlbumRequestBody;
import org.northcoders.recordshopapp.repository.AlbumRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private AlbumRepository albumRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.albumRepository = new AlbumRepository(application);
    }

    public MutableLiveData<List<Album>> getAllAlbums() {
        return albumRepository.getAllAlbums();
    }

    public void addAlbum(NewAlbumRequestBody album) {
        albumRepository.postNewAlbum(album);
    }

//    public MutableLiveData<String> getErrorMessage() {
//        return albumRepository.getErrorMessage();
//    }
}
