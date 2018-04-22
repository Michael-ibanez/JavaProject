package edu.baylor.ecs.csi;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class MainWindow {
    private static Stage window;
    private static Parent root;
    private static Scene curr;

    // Creates instance of MainWindow with no args
    public MainWindow(){

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

    // What happens when we close application
    public void closeProgram(Stage window) {
        boolean flag = ExitMain.display("Alert Window", "No more conversions??");
        if (!flag) {
            System.out.println("Thanks !");
            window.close();
        }
    }

    // Changes on main loading screen
    protected void connectToLoading() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/loginScreen.fxml"));
        curr = new Scene(root);
        curr.getStylesheets().add("/login.css");
    }

    // Changes to settings
    protected void connectToSetting() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/settingScreen.fxml"));
        curr = new Scene(root);
        curr.getStylesheets().add("/settingScreen.css");
    }

    // Changes on converting screen
    protected void connectToHome() throws IOException{
        root = FXMLLoader.load(getClass().getResource("/homeScreen.fxml"));
        curr = new Scene(root);
        curr.getStylesheets().add("/homeScreen.css");
    }


    // Gets current scene
    public static Scene getCurr() {
        return curr;
    }

    // Sets current scene
    public void setCurrentScene(Scene currentScene) {
        this.curr = currentScene;
    }

    // Gets current window
    public static Stage getWindow() {
        return window;
    }

    // Sets current window
    public void setWindow(Stage window) {
        this.window = window;
    }

    // Gets current Main Window
    public MainWindow getMaster(){
        return this;
    }

}