
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks;
    private Storage storage;

    public TaskManager(String filePath){
        storage = new Storage(filePath);
        try {
            this.tasks = storage.loadTasks();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addTodo(String description) throws EmptyDescriptionException {
        if (description.equals("")) {
            throw new EmptyDescriptionException("todo");
        }

        Todo todo = new Todo(description);
        tasks.add(todo);
        save();
        System.out.println("I've added \"" + description + "\" as a todo!");
        System.out.println("Check it out!");
        list();
    }

    public void addDeadline(String second) throws EmptyDescriptionException, DeadlineInvalidDateException {
        if (second.equals("")) {
            throw new EmptyDescriptionException("deadline");
        }

        String[] parts = second.split("/");

        if (parts.length != 2) {
            throw new DeadlineInvalidDateException("deadline");
        }

        String description = parts[0];
        String by = parts[1];
        Deadline deadline = new Deadline(description, by);
        tasks.add(deadline);
        save();
        System.out.println("I've added \"" + description + "\" as a task with deadline!");
        System.out.println("It is to be completed by " + by + ".");
        System.out.println("Check it out!");
        list();
    }

    public void addEvent(String second) throws EmptyDescriptionException, EventInvalidDateException {
        if (second.equals("")) {
            throw new EmptyDescriptionException("event");
        }

        String[] parts = second.split("/");

        if (parts.length != 3) {
            throw new EventInvalidDateException("event");
        }

        String description = parts[0];
        String start = parts[1];
        String end = parts[2];
        Event event = new Event(description, start, end);
        tasks.add(event);
        save();
        System.out.println("I've added \"" + description + "\" as an event!");
        System.out.println("It is from " + start + " to " + end + ".");
        System.out.println("Check it out!");
        list();
    }

    public void mark(String second) {
        int taskIndex = Integer.parseInt(second);
        tasks.get(taskIndex - 1).mark();
        save();
        System.out.println("Marked " + taskIndex + " as done.");
    }

    public void unmark(String second) {
        int taskIndex = Integer.parseInt(second);
        tasks.get(taskIndex - 1).unmark();
        save();
        System.out.println("Unmarked " + taskIndex + ".");
    }

    public void list() {
        if (tasks.isEmpty()) {
            System.out.println("You currently have no task!");
        } else {
            System.out.println("Here are your current tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                int index = i + 1;
                Task t = tasks.get(i);
                System.out.println(index + "." + t);
            }
        }
    }

    public void deleteTask(String second) throws InvalidTaskIndexException {
        try {
            int taskIndex = Integer.parseInt(second);
            tasks.remove(taskIndex - 1);
            System.out.println("I've successfully deleted task " + taskIndex +
                    ". Here are your remaining tasks.");
            save();
            list();
        } catch (Exception e) {
            throw new InvalidTaskIndexException();
        }
    }

    public void save() {
        storage.saveTasks(tasks);
    }
}
