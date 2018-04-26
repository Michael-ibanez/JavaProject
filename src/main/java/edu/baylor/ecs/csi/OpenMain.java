package edu.baylor.ecs.csi;

import static edu.baylor.ecs.csi.MainWindow.getWindow;
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
        getWindow().setScene(mainWindow.getCurr());
        getWindow().show();

        // How to close application using lambda
        // found from tutorial website
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

/*
Since I had a question on the project deliverable, which is specified by another announcement
(all that we covered in the class), here bullets (not replacing the other description and not necessarily complete)

Documentation
Implementation
Testing
Git/management


Documentation
--
Outline
Vision statement
All roles
Gant diagram with timing
Requirements
Business rules (3 or more)
Use cases (3 or more)
Use Case diagram for all roles
System sequence diagram
System Operations
Domain model
Operation contracts
Sequence diagrams (for 3 use cases)
Design model
Justification of GRASPS
single multipage PDF (latex)
Where did you use a design pattern and why?

eye_of_the_tiger
pancakes


Implementation
--
Maven + git
Good quality
Efficient/effective design
5-7 design patterns
Well commented and formatted
Ideally, run https://spotbugs.github.io/ or https://github.com/checkstyle/checkstyle
If I run it and find bugs, these are minus points


Testing
--
Test the use cases that you implemented


Management
--
30+ git commits
Ideally, tracking/ticketing/issue tracking systems
Report hours spent on the project
each individual
Each file has the owner
Report number of logical lines of code
each individual
http://csse.usc.edu/ucc_new/wordpress/
https://github.com/AlDanial/cloc

 */