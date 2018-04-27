/**
 * Author             : Michael Ibanez
 * Date last modified : 4/26/2018
 * Date created       : 4/12/2018
 */

package edu.baylor.ecs.csi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * The type Exit main.
 */
public class ExitMain {

    /**
     * The Yes button.
     */
    @FXML
    Button yes;
    /**
     * The No button.
     */
    @FXML
    Button no;

    private static boolean result = true;
    private static final Stage popUp = new Stage();

    static {
        popUp.initModality(Modality.APPLICATION_MODAL);
    }

    /**
     * Check boolean.
     *      Main function called to bring up pop up window
     *
     * @return the result of yes or no button clicked
     * @throws IOException the io exception
     */
    public static boolean check() throws IOException {
        Parent root;
        Scene curr;

        root = FXMLLoader.load(ExitMain.class.getResource("/exitScreen.fxml"));
        curr = new Scene(root);
        curr.getStylesheets().add("/exitScreen.css");

        popUp.setScene(curr);
        popUp.showAndWait();

        return result;
    }

    /**
     * Yes action.
     *
     * @param event the event if yes is pressed
     */
    public void yesAction(ActionEvent event) {
        result = true;
        popUp.close();
    }

    /**
     * No action.
     *
     * @param event the event if no is pressed
     */
    public void noAction(ActionEvent event) {
        result = false;
        popUp.close();
    }

}
