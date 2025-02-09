package clank.gui;

import clank.Clank;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Clank clank;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/User.png"));
    private Image clankImage = new Image(this.getClass().getResourceAsStream("/images/Clank.png"));

    /**
     * Initializes the GUI components and ensures the scroll bar follows new messages.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /**
     * Injects the Clank instance into the controller and displays the welcome message.
     *
     * @param clank The Clank chatbot instance.
     */
    public void setClank(Clank clank) {
        clank = clank;

        String welcomeMessage = clank.getWelcomeMessage();
        dialogContainer.getChildren().add(DialogBox.getClankDialog(welcomeMessage, clankImage));
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Clank's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = clank.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getClankDialog(response, clankImage)
        );
        userInput.clear();

        if (input.trim().equalsIgnoreCase("bye")) {
            PauseTransition delay = new PauseTransition(Duration.seconds(1));
            delay.setOnFinished(event -> Platform.exit()); // Close app after delay
            delay.play();
        }
    }
}
