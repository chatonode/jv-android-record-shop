package org.northcoders.recordshopapp.dto.album.post;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import org.northcoders.recordshopapp.BR;
import org.northcoders.recordshopapp.model.enums.Currency;
import org.northcoders.recordshopapp.model.enums.Format;

import java.util.List;

public class NewAlbumRequestBody extends BaseObservable {
    @SerializedName(value = "title")
    private String newAlbumTitle;
    @SerializedName(value = "artistIds")
    private List<Long> newAlbumArtistIds;
    @SerializedName(value = "genreIds")
    private List<Long> newAlbumGenreIds;
    @SerializedName(value = "durationInSeconds")
    private Integer newAlbumDurationInSeconds;
    @SerializedName(value = "imageUrl")
    private String newAlbumImageUrl; // nullable
    @SerializedName(value = "releaseYear")
    private Integer newAlbumReleaseYear; // nullable
    @SerializedName(value = "publisher")
    private String newAlbumPublisher; // nullable
    @SerializedName(value = "priceInPences")
    private Integer newAlbumPriceInPences;
    @SerializedName(value = "currency")
    private Currency newAlbumCurrency;
    @SerializedName(value = "format")
    private Format newAlbumFormat;

    public NewAlbumRequestBody() {
    }

    public NewAlbumRequestBody(String newAlbumTitle, List<Long> newAlbumArtistIds, List<Long> newAlbumGenreIds, Integer newAlbumDurationInSeconds, String newAlbumImageUrl, Integer newAlbumReleaseYear, String newAlbumPublisher, Integer newAlbumPriceInPences, Currency newAlbumCurrency, Format newAlbumFormat) {
        this.newAlbumTitle = newAlbumTitle;
        this.newAlbumArtistIds = newAlbumArtistIds;
        this.newAlbumGenreIds = newAlbumGenreIds;
        this.newAlbumDurationInSeconds = newAlbumDurationInSeconds;
        this.newAlbumImageUrl = newAlbumImageUrl;
        this.newAlbumReleaseYear = newAlbumReleaseYear;
        this.newAlbumPublisher = newAlbumPublisher;
        this.newAlbumPriceInPences = newAlbumPriceInPences;
        this.newAlbumCurrency = newAlbumCurrency;
        this.newAlbumFormat = newAlbumFormat;
    }

    @Bindable
    public String getNewAlbumTitle() {
        return newAlbumTitle;
    }

    public void setNewAlbumTitle(String newAlbumTitle) {
        this.newAlbumTitle = newAlbumTitle;
        notifyPropertyChanged(BR.newAlbumTitle);
    }

    @Bindable
    public List<Long> getNewAlbumArtistIds() {
        return newAlbumArtistIds;
    }

    public void setNewAlbumArtistIds(List<Long> newAlbumArtistIds) {
        this.newAlbumArtistIds = newAlbumArtistIds;
        notifyPropertyChanged(BR.newAlbumArtistIds);
    }

    @Bindable
    public List<Long> getNewAlbumGenreIds() {
        return newAlbumGenreIds;
    }

    public void setNewAlbumGenreIds(List<Long> newAlbumGenreIds) {
        this.newAlbumGenreIds = newAlbumGenreIds;
        notifyPropertyChanged(BR.newAlbumGenreIds);
    }

    @Bindable
    public Integer getNewAlbumDurationInSeconds() {
        return newAlbumDurationInSeconds;
    }

    public void setNewAlbumDurationInSeconds(Integer newAlbumDurationInSeconds) {
        this.newAlbumDurationInSeconds = newAlbumDurationInSeconds;
        notifyPropertyChanged(BR.newAlbumDurationInSeconds);
    }

    @Bindable
    public String getNewAlbumImageUrl() {
        return newAlbumImageUrl;
    }

    public void setNewAlbumImageUrl(String newAlbumImageUrl) {
        this.newAlbumImageUrl = newAlbumImageUrl;
        notifyPropertyChanged(BR.newAlbumImageUrl);
    }

    @Bindable
    public Integer getNewAlbumReleaseYear() {
        return newAlbumReleaseYear;
    }

    public void setNewAlbumReleaseYear(Integer newAlbumReleaseYear) {
        this.newAlbumReleaseYear = newAlbumReleaseYear;
        notifyPropertyChanged(BR.newAlbumReleaseYear);
    }

    @Bindable
    public String getNewAlbumPublisher() {
        return newAlbumPublisher;
    }

    public void setNewAlbumPublisher(String newAlbumPublisher) {
        this.newAlbumPublisher = newAlbumPublisher;
        notifyPropertyChanged(BR.newAlbumPublisher);
    }

    @Bindable
    public Integer getNewAlbumPriceInPences() {
        return newAlbumPriceInPences;
    }

    public void setNewAlbumPriceInPences(Integer newAlbumPriceInPences) {
        this.newAlbumPriceInPences = newAlbumPriceInPences;
        notifyPropertyChanged(BR.newAlbumPriceInPences);
    }

    @Bindable
    public Currency getNewAlbumCurrency() {
        return newAlbumCurrency;
    }

    public void setNewAlbumCurrency(Currency newAlbumCurrency) {
        this.newAlbumCurrency = newAlbumCurrency;
        notifyPropertyChanged(BR.newAlbumCurrency);
    }

    @Bindable
    public Format getNewAlbumFormat() {
        return newAlbumFormat;
    }

    public void setNewAlbumFormat(Format newAlbumFormat) {
        this.newAlbumFormat = newAlbumFormat;
        notifyPropertyChanged(BR.newAlbumFormat);
    }
}
