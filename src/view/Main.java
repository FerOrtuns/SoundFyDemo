package view;

import controller.factory.PlaylistFactory;
import controller.factory.TracksFactory;
import model.aplication.SoundFy;
import model.aplication.SoundFyImpl;
import model.domain.Playlist;
import model.domain.Track;

import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        SoundFy soundFy = new SoundFyImpl();
        
        //hola

        TracksFactory tracksF = new TracksFactory();

        var tracksRnd = tracksF.generateListTracksRnd(20);

        System.out.println("Canciones generadas por factory :");

        for (Track track : tracksRnd) {

            System.out.println("Title: " + track.getTitle());
            System.out.println("Artists: " + track.getArtists());
            System.out.println("Genres: " + track.getGenres());
            System.out.println("Release Date: " + track.getReleaseDate());
            System.out.println("URL: " + track.getUrl());
            System.out.println("Duration: " + track.getSeconds() + " seconds");
            System.out.println("Lyrics:\n" + track.getLyrics());
            System.out.println("------------------------------------");
        }

        // ahora creamos las playlists
       // List<Playlist> playlists = new ArrayList<>(); // Crea una lista de reproducción vacía
       // PlaylistFactory playlistFactory = new PlaylistFactory(playlists);
      PlaylistFactory playlistFactory = new PlaylistFactory();

        var playlistsRND = playlistFactory.generatePlaylistRnd(5);

        System.out.println("----------------------------");
        System.out.println("Playlist generadas por factory :");
        System.out.println("----------------------------");

        for (Playlist playlist : playlistsRND) {
            System.out.println("ID: " + playlist.getId());
            System.out.println("Title: " + playlist.getTitle());
            System.out.println("Description: " + playlist.getDescription());
            System.out.println("Comments: " + playlist.getComments());
            System.out.println("CreationDate: " + playlist.getCreationDate());

            //ta mal revisar

          /*  var tracksPlist = soundFy.getTracks(playlist); // listamos la playlist

            for (Track song : tracksPlist){
                System.out.println("track" + song);
            }
*/
           // tracksPlist.forEach(track -> System.out.println(track));


            System.out.println("------------------------------------");
        }

    }

}

