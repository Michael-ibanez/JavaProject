package edu.baylor.ecs.csi;

import javafx.application.Application;
import javafx.stage.Stage;

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
        MainWindow.getWindow().setScene(mainWindow.getCurr());
        MainWindow.getWindow().show();

        // Invokes exit method using lambda
        // found from tutorial website
        MainWindow.getWindow().setOnCloseRequest(e -> mainWindow.closeProgram(MainWindow.getWindow()));
    }
}