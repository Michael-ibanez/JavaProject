package edu.baylor.ecs.csi;

import edu.baylor.ecs.csi.Controllers.SettingsScreenController;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class MainWindow {
    private static Stage window;
    private Parent root;
    private Scene curr;

    // Creates instance of MainWindow with no args
    protected MainWindow(){

    }

    // Creates instance of MainWindow with args
    public MainWindow(Stage otherWindow){
        // Sets the dimensions and title
        window = otherWindow;
        window.setTitle("Currency Converter");
        window.setMinWidth(425);
        window.setMaxWidth(625);
        window.setMinHeight(550);
        window.setMaxHeight(650);
        window.setWidth(475);
        window.setHeight(600);

    }

    // Changes on main loading screen
    void connectToLoading() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/loadingScreen.fxml"));
        curr = new Scene(root);
        curr.getStylesheets().add("/loadingScreen.css");
    }

    // Changes to menu
    public void connectToMenu() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/menuScreen.fxml"));
        curr = new Scene(root);
        curr.getStylesheets().add("/menuScreen.css");
    }

    // Changes on converting screen
    public void connectToConvert() throws IOException{
        root = FXMLLoader.load(getClass().getResource("/convertScreen.fxml"));
        curr = new Scene(root);
        curr.getStylesheets().add("/convertScreen.css");
    }




    // Changes to settings
    public void connectToSetting() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/settingScreen.fxml"));
        curr = new Scene(root);
        curr.getStylesheets().add("/settingScreen.css");
        IntegerProperty brightness = new SimpleIntegerProperty();

        final DoubleBinding colorValue = brightness.multiply(2.55);

        StringExpression styleString = Bindings.format("-fx-base:rgb(%1$.0f , %1$.0f, %1$.0f)", colorValue);

        brightness.set(20);

        root.styleProperty().bind(styleString);
        SettingsScreenController.initBrightnessControl(window, brightness);
    }

    // What happens when we close application
    public void closeProgram(Stage window) throws IOException {

        boolean flag = ExitMain.check();
        if (!flag) {
            System.out.println("Thanks !");
            window.close();
        }
    }

    // Gets current scene
    public Scene getCurr() {
        return curr;
    }

    // Gets current window
    public static Stage getWindow() {
        return window;
    }

    // Sets current window
    protected void setWindow(Stage window) {
        MainWindow.window = window;
    }

    // Gets current Main Window
    public MainWindow getCurrentWindow(){
        return this;
    }

}