package clank.command;

import clank.task.TaskList;
import clank.utility.Ui;
import clank.utility.Storage;

public class SaveCommand extends Command {
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        storage.saveTasks(taskList);
        System.out.println("All the tasks are saved!");
    }
}
