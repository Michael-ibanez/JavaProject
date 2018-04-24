package edu.baylor.ecs.csi;

import com.sun.tools.javac.Main;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class OpenMain extends Application {

    private MainWindow mainWindow;

    // Main program ran
    public static void main(String[] args) {
        Application.launch(args);
    }

    // What main really calls
    @Override
    public void start(Stage window) throws Exception {

        // Goes to main application
        mainWindow = new MainWindow(window);
        mainWindow.connectToLoading();
        mainWindow.getWindow().setScene(mainWindow.getCurr());
        mainWindow.getWindow().show();

        // Invokes exit method using lambda
        // found from tutorial website
        mainWindow.getWindow().setOnCloseRequest(event -> {
            event.consume();
            try {
                mainWindow.closeProgram(MainWindow.getWindow());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}