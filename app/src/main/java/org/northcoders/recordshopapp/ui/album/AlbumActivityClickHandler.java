package org.northcoders.recordshopapp.ui.album;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import org.northcoders.recordshopapp.ui.album.add.AddNewAlbumActivity;

public class AlbumActivityClickHandler {
    private Context context;

    public AlbumActivityClickHandler(Context context) {
        this.context = context;
    }

    public void onAddNewAlbumFABClicked(View view) {
        Intent intent = new Intent(view.getContext(), AddNewAlbumActivity.class);

        context.startActivity(intent);
    }
}
