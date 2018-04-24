package edu.baylor.ecs.csi;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;


class ExitMain {

    private static boolean response;

    public static boolean display (String title, String message){
        Stage alertWindow = new Stage();

        //block user interaction until this is taken care of
        alertWindow.initModality(Modality.APPLICATION_MODAL);
        alertWindow.setTitle(title);
        alertWindow.setMinWidth(300);
        alertWindow.setMinHeight(300);


        Label label = new Label(message);

        //Create buttons
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(e -> {
            response = true;
            alertWindow.close();
        });
        noButton.setOnAction(e -> {
            response = false;
            alertWindow.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,yesButton,noButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        scene.getStylesheets().add("/menuScreen.css");
        alertWindow.setScene(scene);
        alertWindow.showAndWait();

        return response;
    }
}
