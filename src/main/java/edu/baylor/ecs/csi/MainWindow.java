/**
 * Author             : Michael Ibanez
 * Date last modified : 4/26/2018
 * Date created       : 4/12/2018
 */

package edu.baylor.ecs.csi;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

/**
 * The type Main window.
 */
public class MainWindow {
    private static Stage window;
    private Parent root;
    private Scene curr;

    /**
     * Instantiates a new Main window.
     */
    protected MainWindow(){

    }

    /**
     * Instantiates a new Main window.
     *
     * @param otherWindow the other window
     */
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

    /**
     * Connect to loading screen.
     *
     * @throws IOException the io exception
     */
    void connectToLoading() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/loadingScreen.fxml"));
        curr = new Scene(root);
        curr.getStylesheets().add("/loadingScreen.css");
    }

    /**
     * Connect to menu screen.
     *
     * @throws IOException the io exception
     */
    public void connectToMenu() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/menuScreen.fxml"));
        curr = new Scene(root);
        curr.getStylesheets().add("/menuScreen.css");
    }

    /**
     * Connect to convert screen.
     *
     * @throws IOException the io exception
     */
    public void connectToConvert() throws IOException{
        root = FXMLLoader.load(getClass().getResource("/convertScreen.fxml"));
        curr = new Scene(root);
        curr.getStylesheets().add("/convertScreen.css");
    }

    /**
     * Connect to setting screen.
     *
     * @throws IOException the io exception
     */
    public void connectToSetting() throws IOException {
        root = FXMLLoader.load(getClass().getResource("/settingScreen.fxml"));
        curr = new Scene(root);
        curr.getStylesheets().add("/settingScreen.css");
    }

    /**
     * Close program by using boolean from check.
     *
     * @param window the window
     * @throws IOException the io exception
     */
    public void closeProgram(Stage window) throws IOException {
        if (ExitMain.check()) {
            System.out.println("Thanks have a great day!!");
            window.close();
        }
    }

    /**
     * Gets current scene.
     *
     * @return the curr
     */
    public Scene getCurr() {
        return curr;
    }

    /**
     * Gets cureent window.
     *
     * @return the window
     */
    public static Stage getWindow() {
        return window;
    }

    /**
     * Sets window.
     *
     * @param window the window
     */
    protected void setWindow(Stage window) {
        MainWindow.window = window;
    }

}