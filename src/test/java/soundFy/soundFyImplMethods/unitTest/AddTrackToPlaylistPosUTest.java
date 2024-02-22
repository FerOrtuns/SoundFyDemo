package test.java.soundFy.soundFyImplMethods.unitTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.soundFy.controller.factory.InitFactory;
import main.java.soundFy.controller.factory.TracksFactory;
import main.java.soundFy.model.aplication.SoundFy;
import main.java.soundFy.model.aplication.SoundFyImpl;
import main.java.soundFy.model.domain.Playlist;
import main.java.soundFy.model.domain.Track;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AddTrackToPlaylistPosUTest {

    private SoundFy soundFy;
    private List<Playlist> playlistsSel;
    private Track trackToAdd;

    @BeforeEach
    void setUp() {
        soundFy = new SoundFyImpl();
        InitFactory initFactory = new InitFactory();
        playlistsSel = initFactory.initFactoryPlaylists(soundFy, 1);

    }

    @Test
    void testAddTrackToPlaylist() {
        Playlist playlistSel = playlistsSel.get(0);

        // Probamos con varias posiciones de inserción
        for (int position : new int[]{-2, 0, 2, 500}) {
            TracksFactory trackF = new TracksFactory();
            var handle = trackF.generateListTracksRnd(1);
            trackToAdd = handle.get(0);
            int originalSize = soundFy.getTracks(playlistSel).size();
            soundFy.addTrackToPlaylist(playlistSel, position, trackToAdd);
            List<Track> tracksInPlaylist = soundFy.getTracks(playlistSel);

            assertEquals(originalSize + 1, tracksInPlaylist.size(), "Verifica que el tamaño de la lista aumente en 1");
            assertFalse(tracksInPlaylist.isEmpty(), "Verifica que la lista de reproducción no esté vacía");

            List<Track> updatedTracks = soundFy.getTracks(playlistSel);
            int updatedSize = updatedTracks.size();

            if (position < 0) {
                // Si la posición es negativa, esperamos que la canción se añada al inicio de la lista
                assertEquals(trackToAdd, updatedTracks.get(0), "La canción se añadió al inicio de la lista");
            } else if (position >= originalSize) {
                // Si la posición es igual o mayor que el tamaño original, la canción debe ir al final
                assertEquals(trackToAdd, updatedTracks.get(updatedSize - 1), "La canción se añadió al final de la lista");
            } else {
                // Si la posición está dentro del rango válido, esperamos que la canción se añada en esa posición específica
                assertEquals(trackToAdd, updatedTracks.get(position), "La canción se añadió en la posición especificada");
            }


            // Verifica que la canción se añade al final si la posición es igual o mayor que el tamaño actual
            if (position >= originalSize) {
                assertEquals(trackToAdd, tracksInPlaylist.get(originalSize),
                        "Verifica que la canción se añade al final cuando se solicita una posición igual o mayor");
            }
        }
    }
}
