package clank.utility;

import clank.task.Task;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles user interactions for the Clank chatbot.
 */
public class Ui {
    private final Scanner scanner;

    /**
     * Constructs a new Ui instance and initializes the scanner.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the welcome message to the user.
     */
    public void showWelcomeMessage() {
        System.out.println("Greetings! I'm clank.Clank, Ratchet's best friend.\n"
                + "I heard you are in trouble, and I'm here to help.\n"
                + "How may I assist you?");
    }

    /**
     * Displays a horizontal line separator.
     */
    public void showLine() {
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays the goodbye message to the user.
     */
    public void showByeMessage() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * Displays an error message when loading tasks fails.
     */
    public void showLoadingError() {
        System.out.println("Oh no! I've failed to load tasks from the file.");
    }

    /**
     * Displays a custom error message.
     *
     * @param message The error message to display.
     */
    public void showError(String message) {
        System.out.println(message);
    }

    public void showMatchingTasks(ArrayList<Task> matchingTasks) {
        if (matchingTasks.isEmpty()) {
            System.out.println("Sorry, but I can't seem to find any task with this keyword!");
        } else {
            System.out.println("Here are the tasks I found in my database!\n"
                    + "Take a look!");
            for (int i = 0; i < matchingTasks.size(); i++) {
                int index = i + 1;
                Task task = matchingTasks.get(i);
                System.out.println(index + "." + task);
            }
        }
    }

    /**
     * Reads a command from user input.
     *
     * @return The user input as a string.
     */
    public String readCommand() {
        return scanner.nextLine();
    }
}
