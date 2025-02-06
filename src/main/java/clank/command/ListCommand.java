package clank.command;

import clank.task.TaskList;
import clank.utility.Ui;
import clank.utility.Storage;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.listTasks();
    }
}
