package model.unitTests;

import controller.factory.InitFactory;
import model.aplication.SoundFy;
import model.aplication.SoundFyImpl;
import view.console.PrintPlaylists;


public class findByArtistUTest {


    public static void main(String[] args) {

        SoundFy soundFy = new SoundFyImpl();
        InitFactory.initFactory(soundFy);

        var playlists = soundFy.findByArtist("Standard Alien");


        System.out.println("playlist con temas de Standadrd Alien : ");
        System.out.println("------------------------------------");

        PrintPlaylists.printPlaylists(soundFy, playlists);
    }
}
