package model.unitTests;

import controller.factory.InitFactory;
import model.aplication.SoundFy;
import model.aplication.SoundFyImpl;
import view.console.PrintPlaylists;


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