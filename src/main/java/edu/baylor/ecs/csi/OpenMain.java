package edu.baylor.ecs.csi;

import javafx.application.Application;
import javafx.stage.Stage;

public class OpenMain extends Application {

    private MainWindow mainWindow;

    // Main program ran
    public static void main(String[] args) {
        launch(args);
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
        mainWindow.getWindow().setOnCloseRequest(e -> {
            e.consume();
            mainWindow.closeProgram(MainWindow.getWindow());
        });
    }
}