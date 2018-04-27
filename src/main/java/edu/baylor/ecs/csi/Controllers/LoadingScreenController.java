/**
 * Author             : Michael Ibanez
 * Date last modified : 4/26/2018
 * Date created       : 4/12/2018
 */

package edu.baylor.ecs.csi.Controllers;

import edu.baylor.ecs.csi.MainWindow;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;

/**
 * The type Loading screen controller.
 */
public class LoadingScreenController extends MainWindow {

    /**
     * The accept button.
     */
    @FXML
    private Button acceptButton;

    /**
     * The credits hyperlink
     */
    @FXML
    private Hyperlink credits;

    /**
     * Loading screen action.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    public void loadingScreenAction(ActionEvent event) throws IOException{
        this.connectToMenu();
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
}
