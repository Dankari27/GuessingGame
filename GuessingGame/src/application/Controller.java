package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.util.Random;

public class Controller {

    @FXML
    private TextField inputField;

    @FXML
    private Label outputLabel;

    @FXML
    private Text prompt;

    @FXML
    private Button submit;

    @FXML
    private Text title;

    private int randomNumber;
    private int numberOfGuesses;

    @FXML
    public void initialize() {
        // Initialize the random number and reset the guess counter
    	setFocusListeners();
        generateRandomNumber();
        numberOfGuesses = 0;
    }

    private void generateRandomNumber() {
        // Generate a random number between 1 and 100
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;
    }
    
    private void setFocusListeners() {
        // Set focus listeners for the inputField
        inputField.setOnMouseEntered(e -> inputField.setStyle("-fx-border-color: #7EBCE9;")); // Highlight on mouse enter
        inputField.setOnMouseExited(e -> inputField.setStyle("-fx-border-color: null;")); // Remove highlight on mouse exit

        // Set focus listeners for the submit button
        submit.setOnMouseEntered(e -> submit.setStyle("-fx-border-color: #7EBCE9;")); // Highlight on mouse enter
        submit.setOnMouseExited(e -> submit.setStyle("-fx-border-color: null;")); // Remove highlight on mouse exit
        
    }


    @FXML
    void clkBtn(ActionEvent event) {
        // Increment the guess counter
        numberOfGuesses++;

        // Access the entered text using inputField.getText()
        String userInput = inputField.getText();

        try {
            // Parse the user input as an integer
            int userGuess = Integer.parseInt(userInput);

            // Compare the user's guess with the random number
            if (userGuess == randomNumber) {
                outputLabel.setText("Congratulations! You guessed the correct number in " + numberOfGuesses + " guesses.");
            } else if (userGuess < 1 || userGuess > 100) {
                outputLabel.setText("Please enter a number between 1 and 100.");
            } else {
                // Check if the user's guess is too high or too low
                String message = (userGuess < randomNumber) ? "Too low. Try again!" : "Too high. Try again!";
                outputLabel.setText("Incorrect guess. " + message);
            }
        } catch (NumberFormatException e) {
            outputLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

}
