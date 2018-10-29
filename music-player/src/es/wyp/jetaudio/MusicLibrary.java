package es.wyp.jetaudio;

import es.wyp.exceptions.SongPositionWrongException;

import java.util.ArrayList;
import java.util.List;

public class MusicLibrary {

    private static List<Song> songs = new ArrayList<>();

    //Private Default Constructor
    private MusicLibrary() {
    }

    public static void addSongs(List<Song> songs) {
        MusicLibrary.songs.addAll(songs);
    }

    public static void addSong(Song song) {
        MusicLibrary.songs.add(song);
    }

    public static void removeAllSongs() {
        if (!MusicLibrary.songs.isEmpty()) {
            MusicLibrary.songs.clear();
        }
    }

    public static void removeByPosition(int position) throws SongPositionWrongException {

        int realIndex = position - 1;

        if (realIndex < 0) {
            throw new SongPositionWrongException("Position is wrong.");
        } else if (MusicLibrary.songs.size() < realIndex) {
            throw new SongPositionWrongException("Position is wrong.");
        } else {
            MusicLibrary.songs.remove(realIndex);
        }
    }

    public static List<Song> getAllSongs() {
        return MusicLibrary.songs;
    }
}
