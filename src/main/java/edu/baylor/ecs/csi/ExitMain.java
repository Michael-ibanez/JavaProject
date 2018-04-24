package edu.baylor.ecs.csi;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.io.IOException;


public class ExitMain {

    private static boolean result;


    public static boolean check() throws IOException {
        Stage popUp = new Stage();
        Parent root;
        Scene curr;

        Button yes = new Button();
        Button no = new Button();

        yes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result = true;
            }
        });

        no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                result = false;
            }
        });

        root = FXMLLoader.load(ExitMain.class.getResource("/exitScreen.fxml"));
        curr = new Scene(root);
        curr.getStylesheets().add("/exitScreen.css");

        popUp.initModality(Modality.APPLICATION_MODAL);
        popUp.setScene(curr);

        popUp.showAndWait();

        return result;
    }

}
