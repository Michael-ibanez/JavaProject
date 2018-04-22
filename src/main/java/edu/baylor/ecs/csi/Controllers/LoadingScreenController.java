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

    // Creates annoatations for FXML items
    @FXML
    private Button acceptButton;

    @FXML
    private Hyperlink credits;

    // Loading screen event -> Convert screen event
    public void loadingScreen(ActionEvent event) throws IOException{
        this.connectToConvert();
        setWindow((Stage)((Node)event.getSource()).getScene().getWindow());
        getWindow().setScene(getCurr());
        getWindow().show();
        System.out.println("Successfully hit 'accept' button going to convert screen");
    }

    // Credits button
    public void forgotAction(ActionEvent event){
        System.out.println("Created by Michael Ibanez using javaFX");
    }
}
