package clank.command;

import clank.task.TaskList;
import clank.utility.Ui;
import clank.utility.Storage;

public class ByeCommand extends Command {
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showByeMessage();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
