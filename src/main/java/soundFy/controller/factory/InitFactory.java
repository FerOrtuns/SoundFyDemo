package main.java.soundFy.controller.factory;

import main.java.soundFy.model.aplication.SoundFy;
import main.java.soundFy.model.domain.Playlist;
import main.java.soundFy.model.domain.Track;

import java.util.List;
import java.util.Random;

public class InitFactory {

    public List<Playlist> initFactoryPlaylists (SoundFy soundFy, int numberPlaylists){

        PlaylistFactory playlistFactory = new PlaylistFactory();
        List<Playlist> playlistsRND = playlistFactory.generatePlaylistRnd(numberPlaylists);

        for (
                Playlist playlist : playlistsRND) {
                soundFy.addPlaylist(playlist);

            TracksFactory tracksSel = new TracksFactory();
            Random random = new Random();
            int randomNumber = random.nextInt(20) + 3;
            var tracksPL = tracksSel.generateListTracksRnd(randomNumber);
            for (Track song : tracksPL) {
                soundFy.addTrackToPlaylist(playlist, song);
            }
        }

        return playlistsRND;
    };


    public static void initFactory(SoundFy soundFy) {

        PlaylistFactory playlistFactory = new PlaylistFactory();
        List<Playlist> playlistsRND = playlistFactory.generatePlaylistRnd(5);

        for (
                Playlist playlist : playlistsRND) {
            soundFy.addPlaylist(playlist);

            TracksFactory tracksSel = new TracksFactory();
            Random random = new Random();
            int randomNumber = random.nextInt(10) + 3;
            var tracksPL = tracksSel.generateListTracksRnd(randomNumber);
            for (Track song : tracksPL) {
                soundFy.addTrackToPlaylist(playlist, song);
            }
        }

    }
}
