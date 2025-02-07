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

public class AddCommand extends Command {
    private final Task task;

    public AddCommand(String input) {
        String[] parts = input.split(" ", 2);

        String mainCommand = parts[0].toLowerCase();
        String[] details = parts.length > 1 ? parts[1].split("/by | /from | /to ", 3) : new String[]{""};
        String description;

        switch (mainCommand) {
        case "todo":
            if (details.length != 1 || details[0].trim().isEmpty()) {
                throw new InvalidFormatException("todo <description>");
            }

            description = details[0].trim();
            task = new Todo(description);
            System.out.println("I've added \"" + description + "\" as a todo!");
            System.out.println("Check it out!");
            break;
        case "deadline":
            if (details.length != 2 || details[0].trim().isEmpty() || details[1].trim().isEmpty()) {
                throw new InvalidFormatException("deadline <description> /by <d/M/yyyy HHmm>");
            }

            description = details[0].trim();
            String by = details[1].trim();
            task = new Deadline(description, by);
            System.out.println("I've added \"" + description + "\" as a task with deadline!");
            System.out.println("It is to be completed by " + by + ".");
            System.out.println("Check it out!");
            break;
        case "event":
            if (details.length != 3 || details[0].trim().isEmpty() || details[1].trim().isEmpty()
                    || details[2].trim().isEmpty()) {
                throw new InvalidFormatException("event <description> /from d/M/yyyy HHmm /to <d/M/yyyy HHmm>");
            }

            description = details[0].trim();
            String start = details[1].trim();
            String end = details[2].trim();
            task = new Event(description, start, end);
            System.out.println("I've added \"" + description + "\" as an event!");
            System.out.println("It is from " + start + " to " + end + ".");
            System.out.println("Check it out!");
            break;
        default:
            throw new ClankException("Unknown task type.");
        }
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        taskList.addTask(task);
        storage.saveTasks(taskList);
    }
}
