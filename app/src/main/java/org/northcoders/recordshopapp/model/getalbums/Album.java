package org.northcoders.recordshopapp.model.getalbums;

import androidx.databinding.BaseObservable;

import com.google.gson.annotations.SerializedName;

import org.northcoders.recordshopapp.model.Currency;
import org.northcoders.recordshopapp.model.Format;

import java.util.Date;
import java.util.List;

public class Album extends BaseObservable {

    @SerializedName(value = "id")
    private Long id;
    @SerializedName(value = "title")
    private String title;
    @SerializedName(value = "artistIds")
    private List<FlattenedArtist> artists;
    @SerializedName(value = "genreIds")
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
    private Date createdDate;
    @SerializedName(value = "updatedDate")
    private Date updatedDate;

    public Album() {
    }

    public Album(Long id, String title, List<FlattenedArtist> artists, List<FlattenedGenre> genres, Integer durationInSeconds, String imageUrl, Integer releaseYear, String publisher, Integer priceInPences, Currency currency, Integer quantityInStock, Format format, Date createdDate, Date updatedDate) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<FlattenedArtist> getArtists() {
        return artists;
    }

    public void setArtists(List<FlattenedArtist> artists) {
        this.artists = artists;
    }

    public List<FlattenedGenre> getGenres() {
        return genres;
    }

    public void setGenres(List<FlattenedGenre> genres) {
        this.genres = genres;
    }

    public Integer getDurationInSeconds() {
        return durationInSeconds;
    }

    public void setDurationInSeconds(Integer durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getPriceInPences() {
        return priceInPences;
    }

    public void setPriceInPences(Integer priceInPences) {
        this.priceInPences = priceInPences;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
