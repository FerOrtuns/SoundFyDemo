package main.java.soundFy.model.usabilityTest;

import main.java.soundFy.controller.factory.InitFactory;
import main.java.soundFy.controller.factory.TracksFactory;
import main.java.soundFy.model.aplication.SoundFy;
import main.java.soundFy.model.aplication.SoundFyImpl;
import main.java.soundFy.model.domain.Playlist;
import main.java.soundFy.model.domain.Track;
import main.java.soundFy.view.console.PrintPlaylists;

import java.util.List;

public class AddTrackToPlaylistUTest {
    public static void main(String[] args) {


        SoundFy soundFy = new SoundFyImpl();
        InitFactory initFactory = new InitFactory();
        List<Playlist> playlistsSel = initFactory.initFactoryPlaylists(soundFy, 1);

        TracksFactory trackF = new TracksFactory();
        var handle = trackF.generateListTracksRnd(1);
        Track trackToAdd = handle.get(0);

        System.out.println("trackToAdd : " + trackToAdd);

        PrintPlaylists.printPlaylists(soundFy, playlistsSel);

        System.out.println("playlist con tema añadido");
        System.out.println("------------------------------------");


        var playlistSel = playlistsSel.get(0);

        soundFy.addTrackToPlaylist(playlistSel, trackToAdd);

        PrintPlaylists.printPlaylists(soundFy, playlistSel);

    }
}
