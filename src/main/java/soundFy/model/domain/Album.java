package main.java.soundFy.model.domain;

import java.time.LocalDate;
import java.util.List;

public class Album {
    private String title;
    private LocalDate releaseDate;
    private int numberOfSongs;
    private int totalDuration;
    private String coverArt;
    private List<Track> tracks;

    // Constructor
    public Album(String title, LocalDate releaseDate, int numberOfSongs, int totalDuration, String coverArt) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.numberOfSongs = numberOfSongs;
        this.totalDuration = totalDuration;
        this.coverArt = coverArt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getCoverArt() {
        return coverArt;
    }

    public void setCoverArt(String coverArt) {
        this.coverArt = coverArt;
    }

    public List<Track> getSongs() {
        return tracks;
    }

    public void setSongs(List<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", numberOfSongs=" + numberOfSongs +
                ", totalDuration=" + totalDuration +
                ", coverArt='" + coverArt + '\'' +
                ", songs=" + tracks +
                '}';
    }
}
