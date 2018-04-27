/**
 * Author             : Michael Ibanez
 * Date last modified : 4/26/2018
 * Date created       : 4/12/2018
 */

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

/**
 * The type Menu screen controller.
 */
public class MenuScreenController extends MainWindow implements Initializable {

    /**
     * The back button.
     */
    @FXML
    private Button convertButton;

    /**
     * The back button.
     */
    @FXML
    private Button settingButton;

    /**
     * The back button.
     */
    @FXML
    private Button exitButton;


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
     * Convert action.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    public void convertAction(ActionEvent event) throws IOException {

        this.connectToConvert();
        setWindow((Stage)((Node)event.getSource()).getScene().getWindow());
        getWindow().setScene(getCurr());
        getWindow().show();
    }

    /**
     * Sets action.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    public void settingAction(ActionEvent event) throws IOException {

        this.connectToSetting();
        setWindow((Stage)((Node)event.getSource()).getScene().getWindow());
        getWindow().setScene(getCurr());
        getWindow().show();
    }

    /**
     * Credits action.
     *
     * @param event the event
     */
    public void creditsAction(ActionEvent event){
        System.out.println("Created by Michael Ibanez using javaFX");
    }

    /**
     * Close program.
     *      Closes from super (MainWindow)
     *
     * @param event the event
     * @throws IOException the io exception
     */
    public void closeProgram(ActionEvent event) throws IOException {
        super.closeProgram(getWindow());
    }
}
