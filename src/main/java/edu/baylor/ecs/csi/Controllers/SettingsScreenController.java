package edu.baylor.ecs.csi.Controllers;

import edu.baylor.ecs.csi.*;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

import java.awt.*;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SettingsScreenController extends MainWindow implements Initializable{

    private IntegerProperty brightness = new SimpleIntegerProperty();

    @FXML
    private Button exitButton;
    @FXML
    private TextField from;
    @FXML
    private TextField to;
    @FXML
    private TextField resultField;
    @FXML
    private Hyperlink credits;

    // Initialization of window
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getWindow().setWidth(475);
        getWindow().setHeight(600);
    }


    // Credits button
    public void creditsAction(ActionEvent event){
        System.out.println("Created by Michael Ibanez using javaFX");
    }

    // Credits button
    public void githubAction(ActionEvent event){
        System.out.println("Created by Michael Ibanez using javaFX");
    }

    // Credits button
    public void linkedInAction(ActionEvent event){
        System.out.println("Created by Michael Ibanez using javaFX");
    }

    private void initBrightnessControl(Stage primaryStage) {

        Label label = new Label();
        label.textProperty().bind(Bindings.format("Brightness: %1$2d %%", brightness));

        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(100);
        slider.valueProperty().bindBidirectional(brightness);

        VBox root = new VBox();
        root.setSpacing(10);
        root.getChildren().addAll(label, slider);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initOwner(primaryStage);

        stage.show();
    }

    // Close button
    public void closeProgram(ActionEvent event){
        System.out.println("Headed to close program");
        super.closeProgram(getWindow());
    }

}
