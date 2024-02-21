package model.unitTests;

import controller.factory.InitFactory;
import model.aplication.SoundFy;
import model.aplication.SoundFyImpl;
import model.domain.Playlist;
import view.console.PrintPlaylists;

import java.util.List;

public class GetTopArtistsUTest {

    public static void main(String[] args) {

        SoundFy soundFy = new SoundFyImpl();
        InitFactory initFactory = new InitFactory();
        List<Playlist> playlistsSel = initFactory.initFactoryPlaylists(soundFy, 1);
        var playlistSel = playlistsSel.get(0);

        PrintPlaylists.printPlaylists(soundFy, playlistSel);

        var playlist = soundFy.getTopArtists(playlistSel);

        System.out.println("getTopArtists(playlist) : " + playlist);
        System.out.println("------------------------------------");

    }
}
