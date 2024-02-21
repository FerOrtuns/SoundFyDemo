package model.domain;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data

public class Playlist implements Comparable<Playlist> {

    private long id;
    private String title;
    private String description;
    private List<String> comments;
    private LocalDate creationDate;

    public Playlist(long id, String title, String description, List<String> comments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.comments = comments;
        this.creationDate = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    @Override
    public int compareTo(Playlist p) {
        return this.creationDate.compareTo(p.creationDate);
    }
}

//**********************************
/*public class Playlist {
    private String trackName;
    private boolean isPublic;

    // Constructor
    public Playlist(String trackName, boolean isPublic) {
        this.trackName = trackName;
        this.isPublic = isPublic;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "songName='" + trackName + '\'' +
                ", isPublic=" + isPublic +
                '}';
    }*/
