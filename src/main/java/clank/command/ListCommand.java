package clank.command;

import clank.task.TaskList;
import clank.utility.Storage;
import clank.utility.Ui;

public class ListCommand extends Command {
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.listTasks();
    }
}
