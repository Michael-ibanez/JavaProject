/**
 * Author             : Michael Ibanez
 * Date last modified : 4/26/2018
 * Date created       : 4/12/2018
 */

package edu.baylor.ecs.csi;

import static edu.baylor.ecs.csi.MainWindow.getWindow;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * The type Open main.
 */
public class OpenMain extends Application {

    private MainWindow mainWindow;

    /**
     * The entry point of entire application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

    /**
     * What main really calls
     *
     * @param window the Stage needed to create window screen
     */
    @Override
    public void start(Stage window) throws Exception {

        // Goes to main application
        mainWindow = new MainWindow(window);
        mainWindow.connectToLoading();
        getWindow().setScene(mainWindow.getCurr());
        getWindow().show();


        /**
         * Close program by using boolean from check from MainWindow.
         *
         * @throws IOException the io exception
         */
        getWindow().setOnCloseRequest(event -> {
            event.consume();
            try {
                mainWindow.closeProgram(getWindow());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}

// https://www.programcreek.com/java-api-examples/?class=javafx.stage.Stage&method=setOnCloseRequest

// https://examples.javacodegeeks.com/desktop-java/javafx/fxml/javafx-fxml-controller-example/