import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager(ArrayList<Task> tasks){
        this.tasks = tasks;
    }

    public void addTodo(String details) throws EmptyDescriptionException {
        if (details.equals("")) {
            throw new EmptyDescriptionException("todo");
        }

        String description = details.trim();
        Todo todo = new Todo(description);
        tasks.add(todo);
        System.out.println("I've added \"" + details + "\" as a todo!");
        System.out.println("Check it out!");
        list();
    }

    public void addDeadline(String details) throws EmptyDescriptionException, DeadlineInvalidDateException {
        if (details.equals("")) {
            throw new EmptyDescriptionException("deadline");
        }

        String[] parts = details.split("/by");

        if (parts.length < 2) {
            throw new DeadlineInvalidDateException("deadline");
        }

        String description = parts[0].trim();
        String by = parts[1].trim();
        Deadline deadline = new Deadline(description, by);
        tasks.add(deadline);
        System.out.println("I've added \"" + description + "\" as a task with deadline!");
        System.out.println("It is to be completed by " + by + ".");
        System.out.println("Check it out!");
        list();
    }

    public void addEvent(String details) throws EmptyDescriptionException, EventInvalidDateException {
        if (details.equals("")) {
            throw new EmptyDescriptionException("event");
        }

        String[] parts = details.split("/from | /to");

        if (parts.length < 3) {
            throw new EventInvalidDateException("event");
        }

        String description = parts[0].trim();
        String start = parts[1].trim();
        String end = parts[2].trim();
        Event event = new Event(description, start, end);
        tasks.add(event);
        System.out.println("I've added \"" + description + "\" as an event!");
        System.out.println("It is from " + start + " to " + end + ".");
        System.out.println("Check it out!");
        list();
    }

    public void mark(String second) {
        int taskIndex = Integer.parseInt(second);
        tasks.get(taskIndex - 1).mark();
        System.out.println("Marked " + taskIndex + " as done.");
    }

    public void unmark(String second) {
        int taskIndex = Integer.parseInt(second);
        tasks.get(taskIndex - 1).unmark();
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
            list();
        } catch (Exception e) {
            throw new InvalidTaskIndexException();
        }
    }
}
