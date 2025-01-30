import java.util.ArrayList;

public class TaskManager {
    private static ArrayList<Task> tasks = new ArrayList<>();

    public void addTodo(String description) {
        Todo t = new Todo(description);
        tasks.add(t);
        System.out.println("added: " + description);
    }

    public void addDeadline(String second) {
        String[] parts = second.split("/");
        if (parts.length != 2) {
            return;
        }
        String description = parts[0];
        String by = parts[1];
        Deadline d = new Deadline(description, by);
        tasks.add(d);
        System.out.println("added: " + description);
    }

    public void addEvent(String second) {
        String[] parts = second.split("/");
        if (parts.length != 3) {
            return;
        }
        String description = parts[0];
        String start = parts[1];
        String end = parts[2];
        Event e = new Event(description, start, end);
        tasks.add(e);
        System.out.println("added: " + description);
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
        for (int i = 0; i < tasks.size(); i++) {
            int index = i + 1;
            Task t = tasks.get(i);
            System.out.println(index + "." + t);
        }
    }
}
