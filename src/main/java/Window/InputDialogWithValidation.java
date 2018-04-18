package Window;

import GUI.GUIComponent;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InputDialogWithValidation {

    /** The "main" entry method */
    public static void main(String[] args) {
        // Run the GUI code on the Event-Dispatching Thread for thread safety
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUIComponent(); // Let the constructor do the job
            }
        });
    }
}