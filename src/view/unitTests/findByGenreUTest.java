package view.unitTests;

import controller.factory.PlaylistFactory;
import controller.factory.TracksFactory;
import model.aplication.SoundFy;
import model.aplication.SoundFyImpl;
import model.domain.Playlist;
import model.domain.Track;

import java.util.List;
import java.util.Random;

public class findByGenreUTest {


    public static void main(String[] args) {

        SoundFy soundFy = new SoundFyImpl();
        PlaylistFactory playlistFactory = new PlaylistFactory();

        var playlistsRND = playlistFactory.generatePlaylistRnd(5);
        for (Playlist playlist : playlistsRND) {
            soundFy.addPlaylist(playlist);

            TracksFactory tracksSel = new TracksFactory();
            Random random = new Random();
            int randomNumber = random.nextInt(10) + 3;
            var tracksPL = tracksSel.generateListTracksRnd(randomNumber);
            for (Track song : tracksPL) {
                soundFy.addTrackToPlaylist(playlist, song);
            }
        }
        // USANDO METODOS

        var playlists = soundFy.findByGenre("Jazz");
        System.out.println("playlist con el genero Jazz : ");
        System.out.println("------------------------------------");

        for (Playlist playlist : playlists) {
            System.out.println("ID: " + playlist.getId());
            System.out.println("Title: " + playlist.getTitle());
            System.out.println("Description: " + playlist.getDescription());
            System.out.println("Comments: " + playlist.getComments());
            System.out.println("CreationDate: " + playlist.getCreationDate());


            System.out.println("Canciones generadas por factory para cada playlist:");
            List<Track> tracksPlist = soundFy.getTracks(playlist);

            for (Track track : tracksPlist) {

                System.out.println("------------------------------------");
                System.out.println("Title: " + track.getTitle());
                System.out.println("Artists: " + track.getArtists());
                System.out.println("Genres: " + track.getGenres());
                System.out.println("Release Date: " + track.getReleaseDate());
                System.out.println("URL: " + track.getUrl());
                System.out.println("Duration: " + track.getSeconds() + " seconds");
                System.out.println("Lyrics:\n" + track.getLyrics());
                System.out.println("------------------------------------");
            }
            System.out.println("------------------------------------");
        }
    }
}