package clank.command;

import clank.exception.InvalidFormatException;
import clank.task.TaskList;
import clank.utility.Storage;
import clank.utility.Ui;

public class MarkCommand extends Command {
    private int index;

    public MarkCommand(String input) {
        try {
            String[] parts = input.split(" ");
            if (parts.length != 2) {
                throw new InvalidFormatException("mark <index>");
            }
            this.index = Integer.parseInt(parts[1]) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Oh no! That's not a number!");
        }
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            taskList.mark(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please specify a valid index!");
        }
    }
}
