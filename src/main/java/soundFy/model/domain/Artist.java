package main.java.soundFy.model.domain;

import java.time.LocalDate;
import java.util.List;

public class Artist {
    private String name;
    private LocalDate birthDate;
    private String countryOfOrigin;
    private int numberOfAlbums;
    private int numberOfSongs;
    private String biography;
    private List<Album> albums;
    private List<Track> tracks;

    // Constructor

    public Artist(String name, LocalDate birthDate, String countryOfOrigin, int numberOfAlbums, int numberOfSongs, String biography, List<Album> albums, List<Track> tracks) {
        this.name = name;
        this.birthDate = birthDate;
        this.countryOfOrigin = countryOfOrigin;
        this.numberOfAlbums = numberOfAlbums;
        this.numberOfSongs = numberOfSongs;
        this.biography = biography;
        this.albums = albums;
        this.tracks = tracks;
    }


    // Getters y setters
    // ...


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public int getNumberOfAlbums() {
        return numberOfAlbums;
    }

    public void setNumberOfAlbums(int numberOfAlbums) {
        this.numberOfAlbums = numberOfAlbums;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Track> getSongs() {
        return tracks;
    }

    public void setSongs(List<Track> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", numberOfAlbums=" + numberOfAlbums +
                ", numberOfSongs=" + numberOfSongs +
                ", biography='" + biography + '\'' +
                ", albums=" + albums +
                ", songs=" + tracks +
                '}';
    }
}
