/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helperclasses;

import java.nio.file.Paths;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 *
 * @author Mohamed Elsayed
 */
public class Music extends Thread {

    MediaPlayer mediaPlayer;

    public Music(String soundFile, boolean isRepeat) {
        String s = "/resources/sounds/" + soundFile;
        Media h = new Media(getClass().getResource(s).toExternalForm());
        mediaPlayer = new MediaPlayer(h);
        if (isRepeat) {
            mediaPlayer.setOnEndOfMedia(this);
        }
        mediaPlayer.play();

    }

    @Override
    public void run() {
        mediaPlayer.seek(Duration.ZERO);
    }
    
    public void stopMusic(){
        mediaPlayer.stop();
        this.stop();
    }
    
    public void pauseMusic(){
        mediaPlayer.pause();
    }
    
    public void resumeMusic(){
        mediaPlayer.play();
    }
}
