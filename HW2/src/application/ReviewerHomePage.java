package application;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This page displays a simple welcome message for the reviewer.
 */

public class ReviewerHomePage {

    public void show(Stage primaryStage) {
    	VBox layout = new VBox();
	    layout.setStyle("-fx-alignment: center; -fx-padding: 20;");
	    
	    // Label to display Hello user
	    Label reviewerLabel = new Label("Hello, Reviewer!");
	    reviewerLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

	    layout.getChildren().add(reviewerLabel);
	    Scene reviewerScene = new Scene(layout, 800, 400);

	    // Set the scene to primary stage
	    primaryStage.setScene(reviewerScene);
	    primaryStage.setTitle("Reviewer Page");
    	
    }
}