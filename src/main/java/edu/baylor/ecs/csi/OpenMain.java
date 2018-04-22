package edu.baylor.ecs.csi;

import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OpenMain extends Application {

    private MainWindow master;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {

        // Goes to main application
        master = new MainWindow(window);
        master.connectToLoading();
        master.getWindow().setScene(master.getCurr());
        master.getWindow().show();

        // Invokes exit method using lambda
        master.getWindow().setOnCloseRequest(e -> {
            e.consume();
            master.closeProgram(MainWindow.getWindow());
        });
    }

    public void closeProgram() {
        boolean result = ExitMain.display("Alert Window", "Do you really want to leave?");
        if (result) {
            System.out.println("Saving files...");
            master.getWindow().close();
        }
    }

    private void isAccountValid(TextField input, String message) {
        try {
            String user = message;
        } catch (NumberFormatException e) {
            System.out.println("error");
        }
    }
}