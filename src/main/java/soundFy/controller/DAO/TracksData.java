/*
package main.java.soundFy.controller.DAO;

import main.java.soundFy.model.domain.Track;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TracksData {

    private Map<Integer, Track> cache;
    private List<Track> tracks;
    private Random random;


    // Método para obtener la caché de pistas
    public Map<Integer, Track> getCache() {
        return cache;
    }


    public TracksData() {
        this.tracks = new ArrayList<>();
        this.cache = new HashMap<>();
        this.random = new Random();
        generateAndCacheRandomTracks(30);
        this.tracks = getTracks();
    }


    private void generateAndCacheRandomTracks(int numberOfTracks) {
        for (int i = 0; i < numberOfTracks; i++) {
            // Generar datos aleatorios para la pista
            int seconds = random.nextInt(300) + 60; // Duración entre 60 y 360 segundos
            String title = SongBuilder.generateRandomSongName();
            String lyrics = SongBuilder.generateRandomLyrics();
            List<String> artists = generateRandomArtists();
            List<String> genres = generateRandomGenres();
            LocalDate releaseDate = generateRandomReleaseDate();
            String url = generateRandomURL();

            // Crear objeto Track
            Track track = new Track(seconds, title, lyrics, artists, genres, releaseDate, url);

            // Agregar la pista a la lista de pistas
            tracks.add(track);

            // Agregar la pista a la caché
            cache.put(i, track);
        }
    }

    // Método para obtener una pista por su índice desde la caché
    public Track getTrackById(int id) {
        return cache.get(id);
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public Map<String, List<Track>> classifyByTrackName() {
        return cache.values().stream()
                .collect(Collectors.groupingBy(Track::getTitle));
    }

    private List<String> generateRandomArtists() {
        List<String> artists = new ArrayList<>();
        int numArtists = random.nextInt(3) + 1; // Entre 1 y 3 artistas
        for (int i = 0; i < numArtists; i++) {
            artists.add(SongBuilder.randomWords[random.nextInt(SongBuilder.randomWords.length)]);
        }
        return artists;
    }

    private List<String> generateRandomGenres() {
        List<String> genres = new ArrayList<>();
        int numGenres = random.nextInt(3) + 1; // Entre 1 y 3 géneros
        for (int i = 0; i < numGenres; i++) {
            genres.add(SongBuilder.randomWords[random.nextInt(SongBuilder.randomWords.length)]);
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

    public static class SongBuilder {
        // Array de palabras aleatorias
        private static final String[] randomWords = {"love", "heart", "time", "dream", "sky", "fire", "dance", "song", "rain", "life",
                "soul", "ocean", "sun", "wind", "star", "hope", "memory", "wish", "freedom", "magic"};

        // Método estático para generar nombres de canciones aleatorias
        public static String generateRandomSongName() {
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
            Random random = new Random();
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
}

*/
