package clank.command;

import clank.exception.ClankException;
import clank.exception.InvalidFormatException;
import clank.task.Deadline;
import clank.task.Event;
import clank.task.Task;
import clank.task.TaskList;
import clank.task.Todo;
import clank.utility.Storage;
import clank.utility.Ui;

/**
 * Represents a command to add a new task (Todo, Deadline, or Event).
 */
public class AddCommand extends Command {
    private final Task task;

    /**
     * Constructs an {@code AddCommand} based on the user's input.
     * Determines the type of task (Todo, Deadline, or Event) and parses the input accordingly.
     *
     * @param input The raw input string from the user.
     * @throws InvalidFormatException If the input does not match the expected format.
     * @throws ClankException If an unknown task type is encountered.
     */
    public AddCommand(String input) throws InvalidFormatException, ClankException {
        String[] parts = input.split(" ", 2);

        String mainCommand = parts[0].toLowerCase();
        String[] taskDetails = parts.length > 1 ? parts[1].split("/by | /from | /to ", 3) : new String[]{""};
        String description;

        switch (mainCommand) {
        case "todo":
            if (taskDetails.length != 1 || taskDetails[0].trim().isEmpty()) {
                throw new InvalidFormatException("todo <description>");
            }

            description = taskDetails[0].trim();
            task = new Todo(description);
            System.out.println("I've added \"" + description + "\" as a todo!");
            System.out.println("Check it out!");
            break;
        case "deadline":
            if (taskDetails.length != 2 || taskDetails[0].trim().isEmpty() || taskDetails[1].trim().isEmpty()) {
                throw new InvalidFormatException("deadline <description> /by <d/M/yyyy HHmm>");
            }

            description = taskDetails[0].trim();
            String by = taskDetails[1].trim();
            task = new Deadline(description, by);
            System.out.println("I've added \"" + description + "\" as a task with deadline!");
            System.out.println("It is to be completed by " + by + ".");
            System.out.println("Check it out!");
            break;
        case "event":
            if (taskDetails.length != 3 || taskDetails[0].trim().isEmpty() || taskDetails[1].trim().isEmpty()
                    || taskDetails[2].trim().isEmpty()) {
                throw new InvalidFormatException("event <description> /from d/M/yyyy HHmm /to <d/M/yyyy HHmm>");
            }

            description = taskDetails[0].trim();
            String start = taskDetails[1].trim();
            String end = taskDetails[2].trim();
            task = new Event(description, start, end);
            System.out.println("I've added \"" + description + "\" as an event!");
            System.out.println("It is from " + start + " to " + end + ".");
            System.out.println("Check it out!");
            break;
        default:
            throw new ClankException("Unknown task type.");
        }
    }

    /**
     * Executes the add command by adding the task to the task list and saving it to storage.
     *
     * @param taskList The task list to modify.
     * @param ui The UI instance to interact with the user.
     * @param storage The storage system to save the updated task list.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.addTask(task);
        storage.saveTasks(taskList);
    }
}
