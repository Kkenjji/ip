package clank.command;

import clank.task.TaskList;
import clank.utility.Ui;
import clank.utility.Storage;
import clank.exception.InvalidFormatException;

/**
 * Represents a command to mark a task as done.
 */
public class MarkCommand extends Command {
    private int index;

    /**
     * Constructs a {@code MarkCommand} with the specified task index.
     *
     * @param input The raw input containing the task index to mark.
     * @throws InvalidFormatException If the input does not contain a valid index.
     */
    public MarkCommand(String input) throws InvalidFormatException {
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

    /**
     * Executes the mark command, marking the specified task as done.
     *
     * @param taskList The task list containing the task to mark.
     * @param ui The UI instance for user interaction.
     * @param storage The storage system (not modified in this command).
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            taskList.mark(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please specify a valid index!");
        }
    }
}
