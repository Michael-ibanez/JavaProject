package edu.baylor.ecs.csi.Controllers;

import edu.baylor.ecs.csi.*;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.io.IOException;
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
    private Button backButton;
    @FXML
    private TextField from;
    @FXML
    private TextField to;
    @FXML
    private TextField resultField;
    @FXML
    private static Slider brightnessSlider;

    // Initialization of window
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getWindow().setWidth(475);
        getWindow().setHeight(600);

    }

    // Credits button
    public void githubAction(ActionEvent event){
        System.out.println("Created by Michael Ibanez using javaFX");
    }

    // Credits button
    public void linkedInAction(ActionEvent event){
        System.out.println("Created by Michael Ibanez using javaFX");
    }

    public static void initBrightnessControl(Stage primaryStage,IntegerProperty brightness) {

        Label label = new Label();
        label.textProperty().bind(Bindings.format("Brightness: %1$2d %%", brightness));
        brightnessSlider = new Slider();
        brightnessSlider.setMin(0);
        brightnessSlider.setMax(100);
        brightnessSlider.valueProperty().bindBidirectional(brightness);

        VBox root = new VBox();
        root.setSpacing(10);
        root.getChildren().addAll(label, brightnessSlider);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initOwner(primaryStage);

        stage.show();
    }

    // Back button
    public void back(ActionEvent event) throws IOException {
        this.connectToMenu();
        setWindow((Stage)((Node)event.getSource()).getScene().getWindow());
        getWindow().setScene(getCurr());
        getWindow().show();
    }

}
