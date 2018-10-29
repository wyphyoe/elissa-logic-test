package es.wyp.jetaudio;

import es.wyp.exceptions.SongNameEmptyException;
import es.wyp.exceptions.SongTimeWrongException;

public class Song {

    private String name;
    private double time;

    public Song(String name, double time) throws SongNameEmptyException, SongTimeWrongException {

        if (name.isEmpty()) {
            throw new SongNameEmptyException("Song name should not be empty!");
        } else {
            this.name = name;
        }

        if (time <= 0) {
            throw new SongTimeWrongException("Song name should not be empty!");
        } else {
            this.time = time;
        }
    }

    public String getName() {
        return name;
    }

    public double getTime() {
        return time;
    }
}
