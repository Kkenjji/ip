package clank.command;

import clank.exception.InvalidFormatException;
import clank.task.TaskList;
import clank.utility.Storage;
import clank.utility.Ui;

public class DeleteCommand extends Command {
    private int index;
    private boolean toDeleteAll = false;

    public DeleteCommand(String input) {
        try {
            String[] parts = input.split(" ");
            if (parts.length != 2) {
                throw new InvalidFormatException("delete <index> or delete all");
            }
            if (parts[1].toLowerCase().equals("all")) {
                toDeleteAll = true;
            }
            this.index = Integer.parseInt(parts[1]) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Oh no! That's not a number!");
        }
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            taskList.deleteTask(index, toDeleteAll);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please specify a valid index!");
        }
    }
}
