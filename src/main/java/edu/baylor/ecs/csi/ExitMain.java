package edu.baylor.ecs.csi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class ExitMain {

    @FXML
    Button yes;
    @FXML
    Button no;

    private static boolean result = true;
    private static Stage popUp = new Stage();

    static {
        popUp.initModality(Modality.APPLICATION_MODAL);
    }

    public static boolean check() throws IOException {
        Parent root;
        Scene curr;

        root = FXMLLoader.load(ExitMain.class.getResource("/exitScreen.fxml"));
        curr = new Scene(root);
        curr.getStylesheets().add("/exitScreen.css");

        popUp.setScene(curr);
        popUp.showAndWait();

        return result;
    }

    // If yes button is pressed
    public void yesAction(ActionEvent event) throws IOException {
        result = true;
        popUp.close();
    }

    // If no button is pressed
    public void noAction(ActionEvent event) throws IOException {
        result = false;
        popUp.close();
    }

}
