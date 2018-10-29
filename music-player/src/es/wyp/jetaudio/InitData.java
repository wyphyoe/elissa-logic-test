package es.wyp.jetaudio;

import es.wyp.exceptions.SongNameEmptyException;
import es.wyp.exceptions.SongTimeWrongException;

import java.util.ArrayList;
import java.util.List;

public class InitData {

    public static void addSongs() throws SongNameEmptyException, SongTimeWrongException {

        List<Song> songs = new ArrayList<>() {
            {
                add(new Song("My love", 0.1));
                add(new Song("Seasons in the sun", 0.1));
                add(new Song("Fool again", 0.1));
                add(new Song("Uptown girl", 0.1));
            }
        };

        MusicLibrary.addSongs(songs);
    }
}
