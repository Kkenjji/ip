import java.util.Scanner;

public class Ui {
    private final Scanner scanner;

    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public void showWelcomeMessage() {
        System.out.println("Greetings! I'm Clank, Ratchet's best friend.\n"
                + "I heard you are in trouble, and I'm here to help.\n"
                + "How may I assist you?");
    }

    public void showLine() {
        System.out.println("____________________________________________________________");
    }

    public void showByeMessage() {
        System.out.println("Bye. Hope to see you again soon!\n");
    }

    public void showLoadingError() {
        System.out.println("Oh no! I've failed to load tasks from the file.");
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public String readCommand() {
        return scanner.nextLine();
    }
}
