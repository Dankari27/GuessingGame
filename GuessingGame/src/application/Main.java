package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

// The main class that extends Application, required for JavaFX applications
public class Main extends Application {
	
	// The start method is the entry point for JavaFX applications
	@Override
	public void start(Stage primaryStage) {
		try {
			// Load the FXML file to create the UI layout
			AnchorPane root = FXMLLoader.load(getClass().getResource("/Home.fxml"));
			
			// Create a scene with the UI layout and set its dimensions (width: 600, height: 400)
			Scene scene = new Scene(root, 600, 400);
			
			// Set the scene to the primary stage (the main window)
			primaryStage.setScene(scene);
			
			// Make the window not resizable
			primaryStage.setResizable(false);
			
			// Show the primary stage with the loaded scene
			primaryStage.show();
		} catch (Exception e) {
			// Print the stack trace in case of an exception
			e.printStackTrace();
		}
	}
	
	// The main method, which launches the JavaFX application
	public static void main(String[] args) {
		launch(args);
	}
}
