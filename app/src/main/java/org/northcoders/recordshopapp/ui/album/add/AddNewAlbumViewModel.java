package org.northcoders.recordshopapp.ui.album.add;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import org.northcoders.recordshopapp.dto.artist.post.NewArtistRequestBody;
import org.northcoders.recordshopapp.model.artist.Artist;
import org.northcoders.recordshopapp.repository.ArtistRepository;

import java.util.List;

public class AddNewAlbumViewModel extends AndroidViewModel {
    ArtistRepository artistRepository;

    public AddNewAlbumViewModel(@NonNull Application application) {
        super(application);
        this.artistRepository = new ArtistRepository(application);
    }

    public MutableLiveData<List<Artist>> getAllArtists() {
        return artistRepository.getAllArtists();
    }

    public void addArtist(NewArtistRequestBody artist) {
        artistRepository.postNewArtist(artist);
    }
}
