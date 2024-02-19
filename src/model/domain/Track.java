package model.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data

public class Track {

    public Track(String title, List<String> artists, List<String> genres, LocalDate releaseDate, String url, int seconds, String lyrics) {
        this.title = title;
        this.artists = artists;
        this.genres = genres;
        this.releaseDate = releaseDate;
        this.url = url;
        this.seconds = seconds;
        this.lyrics = lyrics;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getArtists() {
        return artists;
    }

    public List<String> getGenres() {
        return genres;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getUrl() {
        return url;
    }

    private String title;
    private List<String> artists;
    private List<String> genres;
    private LocalDate releaseDate;
    private String url;
    private int seconds;
    private String lyrics;
}