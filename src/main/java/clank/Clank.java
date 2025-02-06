package clank;

import clank.command.Command;
import clank.exception.ClankException;
import clank.task.TaskList;
import clank.utility.Parser;
import clank.utility.Storage;
import clank.utility.Ui;

public class Clank {
    private Storage storage;
    private TaskList taskList;
    private Ui ui;

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

    public static void main(String[] args) {
        new Clank("./data/clank.txt").run();
    }
}
