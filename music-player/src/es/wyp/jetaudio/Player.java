package es.wyp.jetaudio;

import es.wyp.exceptions.SongPositionWrongException;
import es.wyp.exceptions.SongTimeWrongException;
import es.wyp.exceptions.SongsEmptyException;
import es.wyp.util.TimeUtil;

import java.util.List;
import java.util.Random;

public class Player {

    public void playAll(List<Song> songs) throws SongsEmptyException {

        if (songs.isEmpty()) {

            throw new SongsEmptyException("There is no song to play.");

        } else {

            int currentSongIndex = 0;

            while (currentSongIndex < songs.size()) {
                this.play(songs.get(currentSongIndex), 0);
                currentSongIndex++;
            }
        }
    }

    public void repeatPlay(List<Song> songs, int startingSongIndex) throws SongsEmptyException, SongPositionWrongException {

        if (songs.isEmpty()) {

            throw new SongsEmptyException("There is no song to play.");

        } else if (startingSongIndex > songs.size() || startingSongIndex < 0) {

            throw new SongPositionWrongException("Start play is wrong.");

        } else {

            int currentSongIndex = startingSongIndex;
            while (currentSongIndex < songs.size()) {

                this.play(songs.get(currentSongIndex), 0);
                currentSongIndex++;

                //For infinite play
                if (currentSongIndex == songs.size()) {
                    currentSongIndex = 0;
                }
            }
        }
    }

    public void currentRepeatPlay(List<Song> songs, int currentSongIndex, int startTime) throws SongsEmptyException, SongPositionWrongException, SongTimeWrongException {

        if (songs.isEmpty()) {

            throw new SongsEmptyException("There is no song to play.");

        } else if (currentSongIndex > songs.size() || currentSongIndex < 0) {

            throw new SongPositionWrongException("Start play is wrong.");

        } else if (startTime < 0) {

            throw new SongTimeWrongException("Song should start from 0 second.");

        } else {

            //First Play From Played Position
            this.play(songs.get(currentSongIndex), startTime);
            //For Next Play From Start
            while (true) {
                this.play(songs.get(currentSongIndex), 0);
            }
        }
    }

    public void playNext(List<Song> songs, int currentSongIndex, boolean isShuffle) throws SongsEmptyException, SongPositionWrongException {

        if (songs.isEmpty()) {

            throw new SongsEmptyException("There is no song to play.");

        } else if (currentSongIndex > songs.size() || currentSongIndex < 0) {

            throw new SongPositionWrongException("Start play is wrong.");

        } else {

            if (isShuffle) {

                //nextInt(max + 1 - min) + min;

                currentSongIndex = new Random().nextInt(songs.size() + 1 - currentSongIndex) + currentSongIndex;
                this.playShuffle(songs, currentSongIndex);

            } else {
                currentSongIndex += 1;

                while (currentSongIndex < songs.size()) {
                    this.play(songs.get(currentSongIndex), 0);
                    currentSongIndex++;
                }
            }
        }

    }

    public void playPrevious(List<Song> songs, int currentSongIndex, boolean isShuffle) throws SongsEmptyException, SongPositionWrongException {

        if (songs.isEmpty()) {

            throw new SongsEmptyException("There is no song to play.");

        } else if (currentSongIndex > songs.size() || currentSongIndex < 0) {

            throw new SongPositionWrongException("Start play is wrong.");

        } else {

            if (isShuffle) {

                currentSongIndex = new Random().nextInt(currentSongIndex + 1);
                this.playShuffle(songs, currentSongIndex);

            } else {
                currentSongIndex--;

                if (currentSongIndex < 0) {
                    currentSongIndex = 0;
                }

                while (currentSongIndex < songs.size()) {
                    this.play(songs.get(currentSongIndex), 0);
                    currentSongIndex++;
                }
            }
        }
    }

    public void playShuffle(List<Song> songs, int startingSongIndex) {

        //First Play From Played Position
        this.play(songs.get(startingSongIndex), 0);

        //For Next Shuffle Play
        Random random = new Random();
        int shuffleIndex = random.nextInt(songs.size());

        while (shuffleIndex < songs.size()) {

            this.play(songs.get(shuffleIndex), 0);

            //For infinite shuffle play
            shuffleIndex = random.nextInt(songs.size());
        }
    }

    public void pause(List<Song> songs, int currentPlayingSongIndex, int currentPlayedTime) {
        //TODO Check player is currently playing
        //Stop Media and Record current time for next resume
    }

    public void resume(List<Song> songs, int playedSongIndex, int playedTime, boolean isShuffle) {

        //First Play From Played Position
        this.play(songs.get(playedSongIndex), playedTime);

        //Normal Play For Next
        int currentSongIndex = playedSongIndex + 1;

        if (currentSongIndex >= songs.size()) {
            currentSongIndex = 0;
        }

        while (currentSongIndex < songs.size()) {

            this.play(songs.get(currentSongIndex), 0);
            currentSongIndex++;

            //For infinite play
            if (currentSongIndex == songs.size()) {
                currentSongIndex = 0;
            }
        }
    }

    private void play(Song song, int startTime) {

        for (int t = startTime; t <= TimeUtil.minutesToSeconds(song.getTime()); t++) {

            System.out.println("Playing ... " + song.getName() + " : " + t + " second");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
