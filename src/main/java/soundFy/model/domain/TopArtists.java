package main.java.soundFy.model.domain;

public record TopArtists(String artist, long occurrence){
    @Override
    public String toString() {
        return "TopArtist{" +
                "Artista='" + artist + '\'' +
                ": " + occurrence +
                '}';
    }
}