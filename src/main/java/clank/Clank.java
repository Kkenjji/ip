package clank;

import clank.command.Command;
import clank.exception.ClankException;
import clank.task.TaskList;
import clank.utility.Parser;
import clank.utility.Storage;
import clank.utility.Ui;

/**
 * The main class for the Clank chatbot.
 * Clank is a simple task management chatbot that allows users to add,
 * delete, list, and mark tasks as done.
 */
public class Clank {
    private Storage storage;
    private TaskList taskList;
    private Ui ui;

    /**
     * Initializes the Clank chatbot with the specified file path for storage.
     * @param filePath The file path where tasks are stored.
     */
    public Clank(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            taskList = new TaskList(storage.loadTasks());
        } catch (ClankException e) {
            ui.showLoadingError();
            taskList = new TaskList();
        }
    }

    /**
     * Runs the Clank chatbot, processing user commands until exit.
     */
    public void run() {
        ui.showWelcomeMessage();
        ui.showLine();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(taskList, ui, storage);
                isExit = c.isExit();
            } catch (ClankException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    /**
     * The main entry point of the Clank chatbot.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        new Clank("./data/clank.txt").run();
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        try {
            Command command = Parser.parse(input);
            if (command.isExit()) {
                ui.showByeMessage();
                return "Goodbye! See you again!";
            }
            return ui.executeCommand(command, taskList, storage);
        } catch (ClankException e) {
            return e.getMessage();
        }
    }

    public String getWelcomeMessage() {
        return ui.getWelcomeMessage();
    }
}
