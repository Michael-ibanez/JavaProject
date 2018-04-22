package edu.baylor.ecs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.media.Media;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class OpenMain extends Application {


    private MasterWindow master;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {

        Media sound = new Media(this.getClass().getResource("/Wolves.m4a").toString());
        MediaPlayer mediaPlayers = new MediaPlayer(sound);
        //mediaPlayers.play();
        //AudioClip note = new AudioClip(this.getClass().getResource("/Wolves.mp3").toString());
        //note.play(100);
        //System.out.println(note.isPlaying());
        //MasterWindow master = new MasterWindow(root, window,  loginScene);



        master = new MasterWindow(window);
        master.connectToLogin();
        master.getWindow().setScene(master.getCurrentScene());
        master.getWindow().show();

        //exit request
        master.getWindow().setOnCloseRequest(e -> {
            //override the close request
            e.consume();
            master.closeProgram(master.getWindow());
            //mediaPlayer.stop();
            //closeProgram();
        });
    }

    public void closeProgram() {
        boolean result = ExitBox.display("Alert Window", "Do you really want to leave?");
        if (result) {
            System.out.println("Saving files...");
            master.getWindow().close();
        }
    }

    private void isAccountValid(TextField input, String message) {
        try {
            String user = message;
        } catch (NumberFormatException e) {
            System.out.println("error");
        }
    }
}