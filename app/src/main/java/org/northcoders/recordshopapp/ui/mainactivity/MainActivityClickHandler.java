package org.northcoders.recordshopapp.ui.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import org.northcoders.recordshopapp.ui.addalbum.AddNewAlbumActivity;

public class MainActivityClickHandler {
    private Context context;

    public MainActivityClickHandler(Context context) {
        this.context = context;
    }

    public void onAddNewAlbumFABClicked(View view) {
        Intent intent = new Intent(view.getContext(), AddNewAlbumActivity.class);

        context.startActivity(intent);
    }
}
