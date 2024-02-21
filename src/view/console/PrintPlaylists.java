package view.console;

import model.aplication.SoundFy;
import model.domain.Playlist;
import model.domain.Track;

import java.util.List;

public class PrintPlaylists {

    public static void printPlaylists(SoundFy soundFy, List<Playlist> playlists) {

        for (Playlist playlist : playlists) {
            System.out.println("ID: " + playlist.getId());
            System.out.println("Title: " + playlist.getTitle());
            System.out.println("Description: " + playlist.getDescription());
            System.out.println("Comments: " + playlist.getComments());
            System.out.println("CreationDate: " + playlist.getCreationDate());


            System.out.println("Tracks :");
            List<Track> tracksPlist = soundFy.getTracks(playlist);

            for (Track track : tracksPlist) {

                System.out.println("------------------------------------");
                System.out.println("Title: " + track.getTitle());
                System.out.println("Artists: " + track.getArtists());
                System.out.println("Genres: " + track.getGenres());
                System.out.println("Release Date: " + track.getReleaseDate());
                System.out.println("URL: " + track.getUrl());
                System.out.println("Duration: " + track.getSeconds() + " seconds");
                // System.out.println("Lyrics:\n" + track.getLyrics());
                System.out.println("------------------------------------");
            }
            System.out.println("------------------------------------");
        }
    }

    public static void printPlaylists(SoundFy soundFy, Playlist playlist) {

        System.out.println("ID: " + playlist.getId());
        System.out.println("Title: " + playlist.getTitle());
        System.out.println("Description: " + playlist.getDescription());
        System.out.println("Comments: " + playlist.getComments());
        System.out.println("CreationDate: " + playlist.getCreationDate());


        System.out.println("Tracks :");
        List<Track> tracksPlist = soundFy.getTracks(playlist);

        for (Track track : tracksPlist) {

            System.out.println("------------------------------------");
            System.out.println("Title: " + track.getTitle());
            System.out.println("Artists: " + track.getArtists());
            System.out.println("Genres: " + track.getGenres());
            System.out.println("Release Date: " + track.getReleaseDate());
            System.out.println("URL: " + track.getUrl());
            System.out.println("Duration: " + track.getSeconds() + " seconds");
            // System.out.println("Lyrics:\n" + track.getLyrics());
            System.out.println("------------------------------------");
        }
        System.out.println("------------------------------------");
    }
}
