package clank.command;

import clank.task.TaskList;
import clank.utility.Ui;
import clank.utility.Storage;
import clank.exception.InvalidFormatException;

public class UnmarkCommand extends Command {
    private int index;

    public UnmarkCommand(String input) {
        try {
            String[] parts = input.split(" ");
            if (parts.length != 2) {
                throw new InvalidFormatException("unmark <index>");
            }
            this.index = Integer.parseInt(parts[1]) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Oh no! That's not a number!");
        }
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            taskList.unmark(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please specify a valid index!");
        }
    }
}
