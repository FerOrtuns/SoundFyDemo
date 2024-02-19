package controller.factory;

import model.domain.Track;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TracksFactory {
    private List<Track> tracks;
    private Random random;
    private static final String[] randomWords = {"love", "heart", "time", "dream", "sky", "fire", "dance", "song", "rain", "life",
            "soul", "ocean", "sun", "wind", "star", "hope", "memory", "wish", "freedom", "magic", "to", "the", "an", "my", "for", "us"};

    public TracksFactory(List<Track> tracks, Random random) {
        this.tracks = tracks;
        this.random = random;
    }

    public TracksFactory() {
        this.random = new Random();
        this.tracks = new ArrayList<>();
    }

    public List<Track> generateListTracksRnd(int numberOfTracks) {

        List<Track> result = new ArrayList<>();

        for (int i = 0; i < numberOfTracks; i++) {
            // Generar datos aleatorios para la pista
            int seconds = random.nextInt(300) + 60; // Duración entre 60 y 360 segundos
            String title = generateRandomSongName();
            String lyrics = generateRandomLyrics();
            List<String> artists = generateRandomArtists();
            List<String> genres = generateRandomGenres();
            LocalDate releaseDate = generateRandomReleaseDate();
            String url = generateRandomURL();

            Track track = new Track(title, artists, genres, releaseDate, url, seconds, lyrics);

            result.add(track);

        }
        return result;

    }

    // metodos random para generar cada pista


    private List<String> generateRandomArtists() {
        List<String> artists = new ArrayList<>();

        int numArtists = random.nextInt(3) + 1; // Entre 1 y 3 artistas
        for (int i = 0; i < numArtists; i++) {
            artists.add(TracksFactory.randomWords[random.nextInt(TracksFactory.randomWords.length)]);
        }
        return artists;
    }

    private List<String> generateRandomGenres() {
        List<String> genres = new ArrayList<>();
        int numGenres = random.nextInt(3) + 1; // Entre 1 y 3 géneros
        for (int i = 0; i < numGenres; i++) {
            genres.add(TracksFactory.randomWords[random.nextInt(TracksFactory.randomWords.length)]);
        }
        return genres;
    }

    private LocalDate generateRandomReleaseDate() {
        long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2023, 12, 31).toEpochDay();
        long randomDay = minDay + random.nextLong() % (maxDay - minDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    private String generateRandomURL() {
        return "http://soundFy.com/" + random.nextInt(1000);
    }


    // Método estático para generar nombres de canciones aleatorias
    private String generateRandomSongName() {
        Random random = new Random();
        StringBuilder songName = new StringBuilder();

        // Generar una cantidad aleatoria de palabras para el nombre de la canción
        int numWords = random.nextInt(3) + 1;

        for (int i = 0; i < numWords; i++) {
            // Agregar una palabra aleatoria seguida de un espacio
            songName.append(randomWords[random.nextInt(randomWords.length)]).append(" ");
        }

        // Convertir la primera letra a mayúscula y eliminar el último espacio
        songName.setCharAt(0, Character.toUpperCase(songName.charAt(0)));
        songName.setLength(songName.length() - 1);

        return songName.toString();
    }


    // Método para generar letras de canciones aleatorias
    public static String generateRandomLyrics() {
        Random random = new Random(); // revisar usar mi random
        StringBuilder lyrics = new StringBuilder();

        // Generar una cantidad aleatoria de líneas para la letra
        int numLines = random.nextInt(10) + 5;

        for (int i = 0; i < numLines; i++) {
            // Generar una cantidad aleatoria de palabras por línea
            int numWords = random.nextInt(5) + 3;

            for (int j = 0; j < numWords; j++) {
                // Agregar una palabra aleatoria seguida de un espacio
                lyrics.append(randomWords[random.nextInt(randomWords.length)]).append(" ");
            }
            // Agregar un salto de línea al final de la línea
            lyrics.append("\n");
        }

        return lyrics.toString();
    }
}
