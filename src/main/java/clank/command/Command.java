package clank.command;

import clank.task.TaskList;
import clank.utility.Storage;
import clank.utility.Ui;

public abstract class Command {
    public abstract void execute(TaskList taskList, Ui ui, Storage storage);

    public boolean isExit() {
        return false;
    }
}
