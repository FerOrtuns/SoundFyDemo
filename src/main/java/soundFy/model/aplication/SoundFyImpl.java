package main.java.soundFy.model.aplication;

import main.java.soundFy.model.domain.Playlist;
import main.java.soundFy.model.domain.TopArtists;
import main.java.soundFy.model.domain.Track;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


public class SoundFyImpl implements SoundFy {


    private final Map<Playlist, List<Track>> map = new HashMap<>();

    @Override
    public boolean addPlaylist(Playlist playlist) {

        if (map.containsKey(playlist.getId())) return false;
        map.put(playlist, new ArrayList<>());
        return true;

        //return map.putIfAbsent(playlist, new ArrayList<>()) == null;
    }
/*
    //TO DO TESTEAR ESTE TRIPLACO  METODOS SOLICITADOS UN DIA PERO EL SIGUIENTE ERAN OTROS, LO DEJO POR CURIOSIDAD

    @Override
    public void addTrackToPlaylist(long playlistId, Track track) {
        if (!map.containsKey(playlistId)) {
            throw new IllegalArgumentException("El ID de la playlist " + playlistId + " no existe en SoundFy");
        }
       *//* var playlistID = map.get(playlistId);
        var tracks = map.get(playlistID);
        tracks.add(track);*//*
        List<Track> tracks = map.get(playlistId); // Obtiene directamente la lista de tracks de la playlist
        tracks.add(track);
    }

    //TO DO TESTEAR ESTE TRIPLACO

    @Override
    public void addTrackToPlaylist(long playlistId, int position, Track track) {
        if (!map.containsKey(playlistId)) {
            throw new IllegalArgumentException("La playlist con ID " + playlistId + " no existe en SoundFy.");
        }

        // Obtener la playlist del mapa usando el ID proporcionado
        List<Track> playlist = map.get(playlistId);

        // Verificar si la canción ya existe en la lista de reproducción
        if (playlist.contains(track)) {
            throw new IllegalArgumentException("La canción " + track.getTitle() + " ya existe en la lista de reproducción.");
        }

        // Asegurar que la posición esté dentro de los límites de la lista
        if (position < 0 || position > playlist.size()) {
            throw new ArrayIndexOutOfBoundsException("La posición especificada está fuera de los límites de la lista de reproducción.");
        }

        // Agregar la canción a la lista de reproducción en la posición especificada
        playlist.add(position, track);

   *//*     var  playlist =  map.get(playlistId);

        if (!map.containsKey(playlistId))
            throw new IllegalArgumentException("La playlist iD" + playlistId + " no existe en SoundFy.");

        if (map.get(playlist).contains(track))
            throw new IllegalArgumentException("La canción " + track.getTitle() + " ya existe en la lista.");
        if (position < 0) position = 0;
        if (position >= getTracks((Playlist) playlist).size()) position = getTracks((Playlist) playlist).size();
        if (position < 0 || position > map.get(playlist).size())
            throw new ArrayIndexOutOfBoundsException("El indice no puede tener ese valor");
        map.get(playlist).add(position, track);*//*
    }*/

    @Override
    public void addTrackToPlaylist(Playlist playlist, Track track) {
        if (!map.containsKey(playlist))
            throw new IllegalArgumentException("La playlist" + playlist.getId() + " no existe en SoundFy.");
        if (map.get(playlist).contains(track))
            throw new IllegalArgumentException("La canción " + track.getTitle() + " ya existe en la lista.");
        map.get(playlist).add(track);
    }

    @Override
    public void addTrackToPlaylist(Playlist playlist, int position, Track track) {

        if (!map.containsKey(playlist))
            throw new IllegalArgumentException("La playlist" + playlist.getId() + " no existe en SoundFy.");
        if (map.get(playlist).contains(track))
            throw new IllegalArgumentException("La canción " + track.getTitle() + " ya existe en la lista.");
        if (position < 0) position = 0;
        if (position >= getTracks(playlist).size()) position = getTracks(playlist).size();
        if (position < 0 || position > map.get(playlist).size())
            throw new ArrayIndexOutOfBoundsException("El indice no puede tener ese valor");
        map.get(playlist).add(position, track);

    }

    @Override
    public List<Track> getTracks(Playlist playlist) {

        if (!map.containsKey(playlist))
            throw new IllegalArgumentException("La playlist" + playlist.getId() + " no existe en Spotify.");
        return List.copyOf(map.get(playlist));

        //return map.get(playlist);
        //  return Collections.unmodifiableList(map.get(playlist));
    }

    @Override
    public Track findLongestTrack(Playlist playlist) {

        return getTracks(playlist).stream()
                .max(Comparator.comparing(Track::getSeconds))
                .orElse(null);
    }


    @Override
    public Track findShortestTrack(Playlist playlist) {

     /*
        var list = new ArrayList<>(map.get(playlist));
        list.sort(Comparator.comparingInt(Track::getSeconds));
        return list.getLast();
        */
        return getTracks(playlist).stream()
                .min(Comparator.comparing(Track::getSeconds))
                .orElse(null);
    }

    @Override
    public Double getAverageDurationTrack(Playlist playlist) {
        return getTracks(playlist).stream()
                .mapToInt(Track::getSeconds).average()
                .orElse(0);
    }

    @Override
    public List<Playlist> findByDates(LocalDate start, LocalDate end) {

        return map.entrySet()
                .stream()
                .filter(entry ->
                        entry.getValue()
                                .stream()
                                .anyMatch(track -> track.getReleaseDate().isBefore(end) &&
                                        track.getReleaseDate().isAfter(start)))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    @Override
    public List<Playlist> findByGenre(String genre) {

        return map.entrySet()
                .stream()
                .filter(entry ->
                        entry.getValue()
                                .stream()
                                .anyMatch(track -> track.getGenres().contains(genre)))
                .map(Map.Entry::getKey)
                .toList();
    }

    @Override
    public List<Playlist> findByArtist(String artist) {

        return map.entrySet()
                .stream()
                .filter(entry ->
                        entry.getValue()
                                .stream()
                                .anyMatch(track -> track.getArtists().contains(artist)))
                .map(Map.Entry::getKey)
                .toList();
    }

    @Override
    public List<Playlist> findByTrackDates(LocalDate start, LocalDate end, String artista) {

        return map.entrySet()
                .stream()
                .filter(entry ->
                        entry.getValue()
                                .stream()
                                .anyMatch(track -> track.getArtists().contains(artista) &&
                                        track.getReleaseDate().isBefore(end) &&
                                        track.getReleaseDate().isAfter(start)))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        /* return findByDates(start,end).stream().filter(entry ->
                entry.getValue()
                        .stream()
                        .anyMatch(track -> track.getArtists().contains(artista)
                .map(Map.Entry::getKey)
                .collect(toList());*/

    }

    @Override
    public Set<String> getGenres(Playlist playlist) {

        return getTracks(playlist).stream()
                .flatMap(trk -> trk.getGenres().stream())
                .collect(Collectors.toSet());
    }

    @Override
    public SortedSet<String> getSortedGenres(Playlist playlist) {

        return new TreeSet<>(getGenres(playlist));
    }

    public List<TopArtists> getTopArtists(Playlist playlist, Integer top) {

        return getTracks(playlist)
                .stream()
                .flatMap(track -> track.getArtists().stream())
                .collect(groupingBy(artist -> artist, counting()))
                .entrySet()
                .stream()
                .map(entry -> new TopArtists(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparing(TopArtists::occurrence).reversed())
                .limit(top)
                .collect(Collectors.toList());

      /*  return getTracks(playlist)
                .stream()
                .flatMap(track -> track.getArtists().stream())
                .collect(groupingBy(artist -> artist, counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .limit(3)
                .collect(Collectors.toList());*/
/*
        Map<String, Long> topArtists = getTracks(playlist)
                .stream()
                .flatMap(track -> track.getArtists().stream())
                .collect(groupingBy(artist -> artist, counting()));

        return topArtists.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(toList());*/
    }
}
