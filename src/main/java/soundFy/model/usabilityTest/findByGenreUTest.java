package main.java.soundFy.model.usabilityTest;

import main.java.soundFy.controller.factory.InitFactory;
import main.java.soundFy.model.aplication.SoundFy;
import main.java.soundFy.model.aplication.SoundFyImpl;
import main.java.soundFy.view.console.PrintPlaylists;


public class findByGenreUTest {


    public static void main(String[] args) {

        SoundFy soundFy = new SoundFyImpl();
        InitFactory.initFactory(soundFy);

        var playlists = soundFy.findByGenre("Jazz");
        System.out.println("playlist con el genero Jazz : ");
        System.out.println("------------------------------------");

        PrintPlaylists.printPlaylists(soundFy, playlists);
    }
}