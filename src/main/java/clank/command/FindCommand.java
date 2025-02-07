package clank.command;

import clank.exception.InvalidFormatException;
import clank.task.Task;
import clank.task.TaskList;
import clank.utility.Storage;
import clank.utility.Ui;

import java.util.ArrayList;

public class FindCommand extends Command {
    private String keyword;

    public FindCommand(String input) {
        String[] parts = input.split(" ");
        if (parts.length != 2 || parts[1].trim().isEmpty()) {
            throw new InvalidFormatException("find <keyword>");
        }
        this.keyword = parts[1].trim();
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ArrayList<Task> matchingTasks = taskList.findTasks(keyword);
        ui.showMatchingTasks(matchingTasks);
    }
}
