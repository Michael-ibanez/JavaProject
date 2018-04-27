/**
 * Author             : Michael Ibanez
 * Date last modified : 4/26/2018
 * Date created       : 4/12/2018
 */

package edu.baylor.ecs.csi.Controllers;

import edu.baylor.ecs.csi.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * The type Settings screen controller.
 */
public class SettingsScreenController extends MainWindow implements Initializable{

    /**
     * The back button.
     */
    @FXML
    private Button backButton;

    /**
     * The inject action button.
     */
    @FXML
    private Button injectButton;

    /**
     * The field for class name to inject to.
     */
    @FXML
    private TextField className;

    /**
     * The field for property to inject.
     */
    @FXML
    private TextField property;

    /**
     * The field for value of property.
     */
    @FXML
    private TextField value;

    /**
     * Initialize
     *    Sets dimension of application window
     *
     * @param l used from super
     * @param r used from super
     */
    @Override
    public void initialize(URL l, ResourceBundle r) {
        getWindow().setWidth(475);
        getWindow().setHeight(600);

    }

    /**
     * Github action.
     *
     * @param event the event
     */
    public void githubAction(ActionEvent event){
        System.out.println("Github : https://github.com/Michael-ibanez/");
    }

    /**
     * Linked in action.
     *
     * @param event the event
     */
    public void linkedInAction(ActionEvent event){
        System.out.println("LinkedIn : https://www.linkedin.com/in/michael-ibanez/");
    }

    /**
     * Inject action.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    public void injectAction(ActionEvent event) throws IOException {
        File log = new File("/convertScreen.css");
        write(log);

        log = new File("/exitScreen.css");
        write(log);

        log = new File("/loadingScreen.css");
        write(log);

        log = new File("/menuScreen.css");
        write(log);

        log = new File("/settingScreen.css");
        write(log);
    }

    /**
     * Back.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    public void back(ActionEvent event) throws IOException {
        this.connectToMenu();
        setWindow((Stage)((Node)event.getSource()).getScene().getWindow());
        getWindow().setScene(getCurr());
        getWindow().show();
    }

    /**
     * Write
     *
     * @param log the file we write to for injection
     * @throws IOException the io exception
     */
    private void write(File log) throws IOException {
        if(!log.exists()){
            System.out.println("File not found! Error!");
        }
        else {

            Writer fileWriter = new OutputStreamWriter(new FileOutputStream(log,true), "UTF-8");

            if(className.getText().equals("")){
                className.setText("root");
            }
            if(property.getText().equals("")){
                property.setText("-fx-background-image");
            }
            if(value.getText().equals("")){
                value.setText("url(/bg.jpg)");
            }

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("\n." + className.getText() + "{\n" +
                    "\t" + property.getText() + " : " + value.getText() + "; \n }");
            bufferedWriter.close();

        }
    }

}
