    package model.unitTests;

    import controller.factory.InitFactory;
    import controller.factory.TracksFactory;
    import model.aplication.SoundFy;
    import model.aplication.SoundFyImpl;
    import model.domain.Playlist;
    import model.domain.Track;
    import view.console.PrintPlaylists;

    import java.util.List;

    public class AddTrackToPlaylist {

        public static void main(String[] args) {

            SoundFy soundFy = new SoundFyImpl();
            InitFactory initFactory = new InitFactory();
            List<Playlist> playlistsSel = initFactory.initFactoryPlaylists(soundFy, 1);

            TracksFactory trackF = new TracksFactory();
            var handle = trackF.generateListTracksRnd(1);
            Track trackToAdd = handle.get(0);

            System.out.println("trackToAdd : " + trackToAdd);

            PrintPlaylists.printPlaylists(soundFy, playlistsSel);

            System.out.println("playlist con tema añadido random con posicion 0");
            System.out.println("------------------------------------");


            var playlistSel = playlistsSel.get(0);

            soundFy.addPlaylist(playlistSel);

            soundFy.addTrackToPlaylist(playlistSel.getId(), trackToAdd);

            PrintPlaylists.printPlaylists(soundFy, playlistSel);
        }
    }
