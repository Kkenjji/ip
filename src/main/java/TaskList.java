import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks){
        this.tasks = tasks;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
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

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("You currently have no task!");
        } else {
            System.out.println("Here are your current tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                int index = i + 1;
                Task task = tasks.get(i);
                System.out.println(index + "." + task);
            }
        }
    }

    public void deleteTask(String second) throws InvalidTaskIndexException {
        try {
            int taskIndex = Integer.parseInt(second);
            if (taskIndex <= 0 || taskIndex > tasks.size()) {
                throw new InvalidTaskIndexException();
            }
            tasks.remove(taskIndex - 1);
            System.out.println("I've successfully deleted task " + taskIndex +
                    ". Here are your remaining tasks.");
            listTasks();
        } catch (Exception e) {
            throw new InvalidTaskIndexException();
        }
    }
}
