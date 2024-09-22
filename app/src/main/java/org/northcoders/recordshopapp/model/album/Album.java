package org.northcoders.recordshopapp.model.album;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import org.northcoders.recordshopapp.BR;
import org.northcoders.recordshopapp.model.enums.Currency;
import org.northcoders.recordshopapp.model.enums.Format;

import java.util.List;

public class Album extends BaseObservable {

    @SerializedName(value = "id")
    private Long albumId;
    @SerializedName(value = "title")
    private String albumTitle;
    @SerializedName(value = "artists")
    private List<ArtistSummary> albumArtists;
    @SerializedName(value = "genres")
    private List<GenreSummary> albumGenres;
    @SerializedName(value = "durationInSeconds")
    private Integer albumDurationInSeconds;
    @SerializedName(value = "imageUrl")
    private String albumImageUrl; // nullable
    @SerializedName(value = "releaseYear")
    private Integer albumReleaseYear; // nullable
    @SerializedName(value = "publisher")
    private String albumPublisher; // nullable
    @SerializedName(value = "priceInPences")
    private Integer albumPriceInPences;
    @SerializedName(value = "currency")
    private Currency albumCurrency;
    @SerializedName(value = "quantityInStock")
    private Integer albumQuantityInStock;
    @SerializedName(value = "format")
    private Format albumFormat;
    @SerializedName(value = "createdDate")
    private String albumCreatedDate;
    @SerializedName(value = "updatedDate")
    private String albumUpdatedDate;

    public Album() {
    }

    public Album(Long albumId, String albumTitle, List<ArtistSummary> albumArtists, List<GenreSummary> albumGenres, Integer albumDurationInSeconds, String albumImageUrl, Integer albumReleaseYear, String albumPublisher, Integer albumPriceInPences, Currency albumCurrency, Integer albumQuantityInStock, Format albumFormat, String albumCreatedDate, String albumUpdatedDate) {
        this.albumId = albumId;
        this.albumTitle = albumTitle;
        this.albumArtists = albumArtists;
        this.albumGenres = albumGenres;
        this.albumDurationInSeconds = albumDurationInSeconds;
        this.albumImageUrl = albumImageUrl;
        this.albumReleaseYear = albumReleaseYear;
        this.albumPublisher = albumPublisher;
        this.albumPriceInPences = albumPriceInPences;
        this.albumCurrency = albumCurrency;
        this.albumQuantityInStock = albumQuantityInStock;
        this.albumFormat = albumFormat;
        this.albumCreatedDate = albumCreatedDate;
        this.albumUpdatedDate = albumUpdatedDate;
    }

    @Bindable
    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
        notifyPropertyChanged(BR.albumId);
    }

    @Bindable
    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
        notifyPropertyChanged(BR.albumTitle);
    }

    @Bindable
    public List<ArtistSummary> getAlbumArtists() {
        return albumArtists;
    }

    public void setAlbumArtists(List<ArtistSummary> albumArtists) {
        this.albumArtists = albumArtists;
        notifyPropertyChanged(BR.albumArtists);
    }

    @Bindable
    public List<GenreSummary> getAlbumGenres() {
        return albumGenres;
    }

    public void setAlbumGenres(List<GenreSummary> albumGenres) {
        this.albumGenres = albumGenres;
        notifyPropertyChanged(BR.albumGenres);
    }

    @Bindable
    public Integer getAlbumDurationInSeconds() {
        return albumDurationInSeconds;
    }

    public void setAlbumDurationInSeconds(Integer albumDurationInSeconds) {
        this.albumDurationInSeconds = albumDurationInSeconds;
        notifyPropertyChanged(BR.albumDurationInSeconds);
    }

    @Bindable
    public String getAlbumImageUrl() {
        return albumImageUrl;
    }

    public void setAlbumImageUrl(String albumImageUrl) {
        this.albumImageUrl = albumImageUrl;
        notifyPropertyChanged(BR.albumImageUrl);
    }

    @Bindable
    public Integer getAlbumReleaseYear() {
        return albumReleaseYear;
    }

    public void setAlbumReleaseYear(Integer albumReleaseYear) {
        this.albumReleaseYear = albumReleaseYear;
        notifyPropertyChanged(BR.albumReleaseYear);
    }

    @Bindable
    public String getAlbumPublisher() {
        return albumPublisher;
    }

    public void setAlbumPublisher(String albumPublisher) {
        this.albumPublisher = albumPublisher;
        notifyPropertyChanged(BR.albumPublisher);
    }

    @Bindable
    public Integer getAlbumPriceInPences() {
        return albumPriceInPences;
    }

    public void setAlbumPriceInPences(Integer albumPriceInPences) {
        this.albumPriceInPences = albumPriceInPences;
        notifyPropertyChanged(BR.albumPriceInPences);
    }

    @Bindable
    public Currency getAlbumCurrency() {
        return albumCurrency;
    }

    public void setAlbumCurrency(Currency albumCurrency) {
        this.albumCurrency = albumCurrency;
        notifyPropertyChanged(BR.albumCurrency);
    }

    @Bindable
    public Integer getAlbumQuantityInStock() {
        return albumQuantityInStock;
    }

    public void setAlbumQuantityInStock(Integer albumQuantityInStock) {
        this.albumQuantityInStock = albumQuantityInStock;
        notifyPropertyChanged(BR.albumQuantityInStock);
    }

    @Bindable
    public Format getAlbumFormat() {
        return albumFormat;
    }

    public void setAlbumFormat(Format albumFormat) {
        this.albumFormat = albumFormat;
        notifyPropertyChanged(BR.albumFormat);
    }

    @Bindable
    public String getAlbumCreatedDate() {
        return albumCreatedDate;
    }

    public void setAlbumCreatedDate(String albumCreatedDate) {
        this.albumCreatedDate = albumCreatedDate;
        notifyPropertyChanged(BR.albumCreatedDate);
    }

    @Bindable
    public String getAlbumUpdatedDate() {
        return albumUpdatedDate;
    }

    public void setAlbumUpdatedDate(String albumUpdatedDate) {
        this.albumUpdatedDate = albumUpdatedDate;
        notifyPropertyChanged(BR.albumUpdatedDate);
    }
}
