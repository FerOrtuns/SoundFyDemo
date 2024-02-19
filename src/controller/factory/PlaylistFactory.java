package controller.factory;

import model.aplication.SoundFy;
import model.aplication.SoundFyImpl;
import model.domain.Playlist;
import model.domain.Track;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlaylistFactory {

    private List<Playlist> playlists;
    private Random random;
    private static final String[] adjectives = {
            "Amazing", "Awesome", "Fantastic", "Incredible", "Excellent", "Great", "Superb", "Wonderful", "Fabulous", "Terrific"
    };

    private static final String[] feelings = {
            "happy", "exciting", "uplifting", "energetic", "relaxing", "soothing", "motivating", "inspiring", "nostalgic", "joyful"
    };
    private static final String[] funnyComments = {
            "This playlist is my new addiction!",
            "I've been listening to this playlist non-stop, send help!",
            "Who needs therapy when you have this playlist?",
            "This playlist is my spirit animal.",
            "I'm not saying this playlist saved my life, but...",
            "If this playlist were a person, I'd marry it!",
            "Whoever made this playlist deserves a medal!",
            "This playlist has more hits than my ex!"
    };

    private static final String[] topics = {
            "music", "vibes", "tunes", "melodies", "tracks", "sounds", "beats", "rhythms", "harmonies", "songs"
    };
    private static final String[] randomWords = {
            "Chill",
            "Relax",
            "Party",
            "Vibes",
            "Groove",
            "Summer",
            "Night",
            "Rock",
            "Indie",
            "Jazz",
            "Blues",
            "Electronic",
            "Rhythm",
            "Soul",
            "Funk",
            "Country",
            "Acoustic",
            "Rap",
            "HipHop",
            "Reggae",
            "Pop",
            "Alternative",
            "Classical",
            "Study",
            "Workout",
            "Motivation",
            "Feelings",
            "RoadTrip",
            "Travel",
            "Morning",
            "Afternoon",
            "Evening",
            "Weekend",
            "Nostalgia",
            "Love",
            "Romance",
            "Peace",
            "Hope",
            "Dreams",
            "Inspiration",
            "Ambient",
            "Nature",
            "Chillout",
            "Lounge"
    };

    // CONSTRUCTORES

    public PlaylistFactory(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public PlaylistFactory(List<Playlist> playlists, Random random) {
        this.playlists = playlists;
        this.random = random;
    }

    public PlaylistFactory() {
        this.random = new Random();
        this.playlists = playlists;

    }

    // METODOS

    public List<Playlist> generatePlaylistRnd(int numberPlaylists) {
        List<Playlist> result = new ArrayList<>();
        //List<Playlist> result = new ArrayList<>(map.get(playlist));
        long id = 0;
        random = new Random();
// List<Playlist> playlists = new ArrayList<>(); // Crea una lista de reproducción vacía
        // PlaylistFactory playlistFactory = new PlaylistFactory(playlists);

        for (int i = 0; i < numberPlaylists; i++) {
            // Generar datos aleatorios para las playlists

            id += 1; // bueno el id en orden
            String title = generateRandomTittle();
            String description = generateRandomDescription();
            List<String> comments = generateRandomComments();

            Playlist playlist = new Playlist(id, title, description, comments);

            result.add(playlist);

            SoundFy soundFy = new SoundFyImpl();
            soundFy.addPlaylist(playlist);

            TracksFactory tracksSel = new TracksFactory();
            int randomNumber = random.nextInt(10) + 3;
            var tracksPL = tracksSel.generateListTracksRnd(randomNumber);
            for (Track song : tracksPL) {
                soundFy.addTrackToPlaylist(playlist, song);
            }
        }

        return result;
    }

    private String generateRandomDescription() {

        Random random = new Random();
        String adjective = adjectives[random.nextInt(adjectives.length)];
        String feeling = feelings[random.nextInt(feelings.length)];
        String topic = topics[random.nextInt(topics.length)];

        return "This playlist is " + adjective + " and " + feeling + ". Enjoy the best " + topic + " here!";
    }


    private List<String> generateRandomComments() {

        List<String> comments = new ArrayList<>();
        Random random = new Random();
        int numComments = random.nextInt(4); // Genera un número aleatorio entre 0 y 3

        for (int i = 0; i < numComments; i++) {
            String comment = funnyComments[random.nextInt(funnyComments.length)];
            comments.add(comment);
        }

        return comments;
    }

    ;

    // METODOS RND

    private String generateRandomTittle() {
        Random random = new Random();
        StringBuilder playlistName = new StringBuilder();

        // Generar una cantidad aleatoria de palabras para el nombre de la canción
        int numWords = random.nextInt(1) + 1;

        for (int i = 0; i < numWords; i++) {
            // Agregar una palabra aleatoria seguida de un espacio
            playlistName.append(randomWords[random.nextInt(randomWords.length)]).append(" ");
        }

        // Convertir la primera letra a mayúscula y eliminar el último espacio
        playlistName.setCharAt(0, Character.toUpperCase(playlistName.charAt(0)));
        playlistName.setLength(playlistName.length() - 1);

        return playlistName.toString();
    }

}