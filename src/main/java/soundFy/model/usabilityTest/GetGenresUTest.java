package main.java.soundFy.model.usabilityTest;

import main.java.soundFy.controller.factory.InitFactory;
import main.java.soundFy.model.aplication.SoundFy;
import main.java.soundFy.model.aplication.SoundFyImpl;
import main.java.soundFy.model.domain.Playlist;
import main.java.soundFy.view.console.PrintPlaylists;

import java.util.List;

public class GetGenresUTest {

    public static void main(String[] args) {

        SoundFy soundFy = new SoundFyImpl();
        InitFactory initFactory = new InitFactory();
        List<Playlist> playlistsSel = initFactory.initFactoryPlaylists(soundFy, 1);
        var playlistSel = playlistsSel.get(0);

        PrintPlaylists.printPlaylists(soundFy, playlistSel);

        var playlist = soundFy.getGenres(playlistSel);

        System.out.println("GetGenresUTest(playlist) : " + playlist.toString());
        System.out.println("------------------------------------");

    }
    }

