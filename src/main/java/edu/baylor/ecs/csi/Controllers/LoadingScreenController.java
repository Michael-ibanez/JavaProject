package edu.baylor.ecs.csi.Controllers;

import edu.baylor.ecs.csi.MainWindow;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;

// Controller for loading screen
public class LoadingScreenController extends MainWindow {

    // Creates annotations for FXML items
    @FXML
    private Button acceptButton;

    @FXML
    private Hyperlink credits;

    // Loading screen event
    public void loadingScreenAction(ActionEvent event) throws IOException{
        this.connectToMenu();
        setWindow((Stage)((Node)event.getSource()).getScene().getWindow());
        getWindow().setScene(getCurr());
        getWindow().show();
    }

    // Credits button
    public void creditsAction(ActionEvent event){
        System.out.println("Created by Michael Ibanez using javaFX");
    }
}
