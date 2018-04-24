package edu.baylor.ecs.csi.Controllers;

import edu.baylor.ecs.csi.*;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class SettingsScreenController extends MainWindow implements Initializable{

    @FXML
    private Button backButton;
    @FXML
    private Button injectButton;
    @FXML
    private TextField className;
    @FXML
    private TextField property;
    @FXML
    private TextField value;

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

    public void injectAction(ActionEvent event) throws IOException {
        File log = new File("/Users/michaelibanez/JavaProject/src/main/resources/convertScreen.css");
        write(log);

        log = new File("/Users/michaelibanez/JavaProject/src/main/resources/exitScreen.css");
        write(log);

        log = new File("/Users/michaelibanez/JavaProject/src/main/resources/loadingScreen.css");
        write(log);

        log = new File("/Users/michaelibanez/JavaProject/src/main/resources/menuScreen.css");
        write(log);

        log = new File("/Users/michaelibanez/JavaProject/src/main/resources/settingScreen.css");
        write(log);
    }

    // Back button
    public void back(ActionEvent event) throws IOException {
        this.connectToMenu();
        setWindow((Stage)((Node)event.getSource()).getScene().getWindow());
        getWindow().setScene(getCurr());
        getWindow().show();
    }

    public void write(File log) throws IOException {
        if(!log.exists()){
            System.out.println("We had to make a new file.");

        }
        else {

            FileWriter fileWriter = new FileWriter(log, true);
            if(className.getText().equals("")){
                className.setText("root");
            }
            if(property.getText().equals("")){
                property.setText("");
            }
            if(value.getText().equals("")){
                value.setText("");
            }

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("\n." + className.getText() + "{\n" +
                    "\t" + property.getText() + " : " + value.getText() + "; \n }");
            bufferedWriter.close();

            System.out.println("Done");
        }
    }

}
