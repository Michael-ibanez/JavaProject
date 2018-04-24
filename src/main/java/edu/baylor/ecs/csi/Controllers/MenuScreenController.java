package edu.baylor.ecs.csi.Controllers;

import edu.baylor.ecs.csi.MainWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuScreenController extends MainWindow implements Initializable {

    @FXML
    private Button convertButton;
    @FXML
    private Button settingButton;
    @FXML
    private Button exitButton;

    // Initialization of window
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getWindow().setWidth(475);
        getWindow().setHeight(600);
    }

    // If convert button is pressed
    public void convertAction(ActionEvent event) throws IOException {
        System.out.println("Headed to convert");

        this.connectToConvert();
        setWindow((Stage)((Node)event.getSource()).getScene().getWindow());
        getWindow().setScene(getCurr());
        getWindow().show();
    }

    // If setting button is pressed
    public void settingAction(ActionEvent event) throws IOException {
        System.out.println("Headed to settings");

        this.connectToSetting();
        setWindow((Stage)((Node)event.getSource()).getScene().getWindow());
        getWindow().setScene(getCurr());
        getWindow().show();
    }

    // Credits button
    public void creditsAction(ActionEvent event){
        System.out.println("Created by Michael Ibanez using javaFX");
    }

    // Close button
    public void closeProgram(ActionEvent event){
        System.out.println("Headed to close program");
        super.closeProgram(getWindow());
    }
}
