package org.northcoders.recordshopapp.ui.mainactivity;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import org.northcoders.recordshopapp.R;
import org.northcoders.recordshopapp.databinding.AlbumItemLayoutBinding;
import org.northcoders.recordshopapp.model.album.Album;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumItemViewHolder> {
    private final static String TAG = AlbumAdapter.class.getSimpleName();
    private Context context;
    private List<Album> albumItems;
    private List<Album> filteredAlbumItems;

    public AlbumAdapter(Context context, List<Album> albumItems) {
        this.context = context;
        this.albumItems = albumItems;
    }

    @NonNull
    @Override
    public AlbumItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AlbumItemLayoutBinding albumItemLayoutBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.album_item_layout,
                parent,
                false
        );

        return new AlbumItemViewHolder(albumItemLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumItemViewHolder holder, int position) {

//        ImageView imageView = (ImageView) findViewById(R.id.imageView_album_image);
//        Glide.with(holder.albumImageUrl).load(albumItem.getImageUrl()).into(imageView);
//        holder.albumImageUrl = Glide.with(holder.albumImageUrl).load(albumItem.getImageUrl()).into(R.id.imageView_album_image);
//        holder.albumImageUrl.setImageResource();
//        holder.albumId.setText(albumItem.getId() >= 100
//                ? String.valueOf(albumItem.getId())
//                : albumItem.getId() >= 10
//                ? "0" + String.valueOf(albumItem.getId())
//                : "00" + String.valueOf(albumItem.getId()));
//        holder.albumTitle.setText(albumItem.getTitle());

        Log.d(TAG, "albumItems.size(): " + albumItems.size());

        if (filteredAlbumItems != null && !filteredAlbumItems.isEmpty()) {
            Album filteredAlbumItem = filteredAlbumItems.get(position);
            Log.d(TAG, "filteredAlbumItems.size(): " + filteredAlbumItems.size());
            holder.albumItemLayoutBinding.setAlbum(filteredAlbumItem);
        }

        Album albumItem = albumItems.get(position);

        holder.albumItemLayoutBinding.setAlbum(albumItem);
    }

    @Override
    public int getItemCount() {
        return albumItems.size();
    }

    public void setFilteredList(List<Album> filteredAlbumList) {
        this.albumItems = filteredAlbumList;
        notifyDataSetChanged();
    }


    public static class AlbumItemViewHolder extends RecyclerView.ViewHolder {
        AlbumItemLayoutBinding albumItemLayoutBinding;

        public AlbumItemViewHolder(@NonNull AlbumItemLayoutBinding albumItemLayoutBinding) {
            super(albumItemLayoutBinding.getRoot());
            this.albumItemLayoutBinding = albumItemLayoutBinding;
        }
    }
}
