package model.aplication;

import model.domain.Playlist;
import model.domain.Track;

import java.time.LocalDate;
import java.util.*;

public class SoundFyImpl implements SoundFy {


    private final Map<Playlist, List<Track>> map = new HashMap<>();

    @Override
    public boolean addPlaylist(Playlist playlist) {

        if (map.containsKey(playlist)) return false;
        map.put(playlist, new ArrayList<>());

        return true;
        //return map.putIfAbsent(playlist, new ArrayList<>()) == null;
    }

    @Override
    public void addTrackToPlaylist(long playlistId, Track track) {

    }

    @Override
    public void addTrackToPlaylist(long playlistId, int position, Track track) {

    }
/*
    @Override
    public List<Track> getTracks(long playlistId) {
        return null;
    }*/

    @Override
    public void addTrackToPlaylist(Playlist playlist, Track track) {
        if (!map.containsKey(playlist)) {
            // map.put(playlist, new ArrayList<>());
            throw new IllegalArgumentException("La playlist " + playlist.getId() + " no existe en Spotify");
        }
        var tracks = map.get(playlist);
        tracks.add(track);
    }

    @Override
    public void addTrackToPlaylist(Playlist playlist, int position, Track track) {
        if (!map.containsKey(playlist)) {
            throw new IllegalArgumentException("La playlist " + playlist.getId() + " no existe en Spotify");
        }

        if (position < 0) position = 0;
        if (position >= getTracks(playlist).size()) position = getTracks(playlist).size();

        var tracks = map.get(playlist);
        tracks.add(position, track);
    }

    @Override
    public List<Track> getTracks(Playlist playlist) {

        return map.get(playlist);
        //  return Collections.unmodifiableList(map.get(playlist));
    }

    @Override
    public Track findLongestTrack(Playlist playlist) {
        return null;
    }

    @Override
    public Track findShortestTrack(Playlist playlist) {
        return null;
    }

    @Override
    public Double getAverageDurationTrack(Playlist playlist) {
        return null;
    }

    @Override
    public List<Playlist> findByDates(LocalDate start, LocalDate end) {
        return null;
    }

    @Override
    public List<Playlist> findByGenre(String genre) {

        // List<Playlist> listaResult = new ArrayList<>();

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
        return null;
    }

    @Override
    public List<Playlist> findByTrackDates(LocalDate start, LocalDate end, String artista) {
        return null;
    }

    @Override
    public Set<String> getGenres(Playlist playlist) {
        return null;
    }

    @Override
    public SortedSet<String> getSortedGenres(Playlist playlist) {
        return null;
    }

    @Override
    public List<String> getTopArtists(Playlist playlist) {
        return null;
    }
}
