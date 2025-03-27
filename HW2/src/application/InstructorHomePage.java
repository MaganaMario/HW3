package application;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This page displays a simple welcome message for the instructor.
 */

public class InstructorHomePage {

    public void show(Stage primaryStage) {
    	VBox layout = new VBox();
	    layout.setStyle("-fx-alignment: center; -fx-padding: 20;");
	    
	    // Label to display Hello user
	    Label instructorLabel = new Label("Hello, Instructor!");
	    instructorLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

	    layout.getChildren().add(instructorLabel);
	    Scene instructorScene = new Scene(layout, 800, 400);

	    // Set the scene to primary stage
	    primaryStage.setScene(instructorScene);
	    primaryStage.setTitle("Instructor Page");
    	
    }
}