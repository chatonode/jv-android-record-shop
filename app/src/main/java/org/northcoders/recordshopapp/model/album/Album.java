package org.northcoders.recordshopapp.model.album;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import org.northcoders.recordshopapp.BR;
import org.northcoders.recordshopapp.model.enums.album.Currency;
import org.northcoders.recordshopapp.model.enums.album.Format;

import java.util.List;

public class Album extends BaseObservable {

    @SerializedName(value = "id")
    private Long id;
    @SerializedName(value = "title")
    private String title;
    @SerializedName(value = "artists")
    private List<FlattenedArtist> artists;
    @SerializedName(value = "genres")
    private List<FlattenedGenre> genres;
    @SerializedName(value = "durationInSeconds")
    private Integer durationInSeconds;
    @SerializedName(value = "imageUrl")
    private String imageUrl; // nullable
    @SerializedName(value = "releaseYear")
    private Integer releaseYear; // nullable
    @SerializedName(value = "publisher")
    private String publisher; // nullable
    @SerializedName(value = "priceInPences")
    private Integer priceInPences;
    @SerializedName(value = "currency")
    private Currency currency;
    @SerializedName(value = "quantityInStock")
    private Integer quantityInStock;
    @SerializedName(value = "format")
    private Format format;
    @SerializedName(value = "createdDate")
    private String createdDate;
    @SerializedName(value = "updatedDate")
    private String updatedDate;

    public Album() {
    }

    public Album(Long id, String title, List<FlattenedArtist> artists, List<FlattenedGenre> genres, Integer durationInSeconds, String imageUrl, Integer releaseYear, String publisher, Integer priceInPences, Currency currency, Integer quantityInStock, Format format, String createdDate, String updatedDate) {
        this.id = id;
        this.title = title;
        this.artists = artists;
        this.genres = genres;
        this.durationInSeconds = durationInSeconds;
        this.imageUrl = imageUrl;
        this.releaseYear = releaseYear;
        this.publisher = publisher;
        this.priceInPences = priceInPences;
        this.currency = currency;
        this.quantityInStock = quantityInStock;
        this.format = format;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    @Bindable
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public List<FlattenedArtist> getArtists() {
        return artists;
    }

    public void setArtists(List<FlattenedArtist> artists) {
        this.artists = artists;
        notifyPropertyChanged(BR.artists);
    }

    @Bindable
    public List<FlattenedGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<FlattenedGenre> genres) {
        this.genres = genres;
        notifyPropertyChanged(BR.genres);
    }

    @Bindable
    public Integer getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(Integer durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
        notifyPropertyChanged(BR.durationInSeconds);
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        notifyPropertyChanged(BR.imageUrl);
    }

    @Bindable
    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
        notifyPropertyChanged(BR.releaseYear);
    }

    @Bindable
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
        notifyPropertyChanged(BR.publisher);
    }

    @Bindable
    public Integer getPriceInPences() {
        return priceInPences;
    }

    public void setPriceInPences(Integer priceInPences) {
        this.priceInPences = priceInPences;
        notifyPropertyChanged(BR.priceInPences);
    }

    @Bindable
    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
        notifyPropertyChanged(BR.currency);
    }

    @Bindable
    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
        notifyPropertyChanged(BR.quantityInStock);
    }

    @Bindable
    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
        notifyPropertyChanged(BR.format);
    }

    @Bindable
    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
        notifyPropertyChanged(BR.createdDate);
    }

    @Bindable
    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
        notifyPropertyChanged(BR.updatedDate);
    }
}
