package es.wyp;

import es.wyp.exceptions.SongNameEmptyException;
import es.wyp.exceptions.SongPositionWrongException;
import es.wyp.exceptions.SongTimeWrongException;
import es.wyp.exceptions.SongsEmptyException;
import es.wyp.jetaudio.InitData;
import es.wyp.jetaudio.MusicLibrary;
import es.wyp.jetaudio.Player;
import es.wyp.jetaudio.Song;

import java.util.List;

public class Main {

    public static void main(String[] args) throws SongNameEmptyException, SongTimeWrongException, SongsEmptyException, SongPositionWrongException {

        InitData.addSongs();

        List<Song> songs = MusicLibrary.getAllSongs();

        for (Song song : songs) {
            System.out.println(song.getName() + " " + song.getTime());
        }

        Player player = new Player();
        player.playAll(songs);
//        player.repeatPlay(songs, 2);
//        player.currentRepeatPlay(songs, 3, 3);
//        player.playNext(songs, 1, true);
//        player.playPrevious(songs,0,true);
//        player.playShuffle(songs, 2);
//        player.resume(songs,3,4);
    }
}
