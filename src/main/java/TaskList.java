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

    public void markTask(int index) {
        if (index < 0 || index > tasks.size()) {
            throw new InvalidFormatException();
        }
        tasks.get(index).mark();
        System.out.println("Marked " + index + " as done.");
    }

    public void unmarkTask(int index) {
        if (index < 0 || index > tasks.size()) {
            throw new InvalidFormatException();
        }
        tasks.get(index).unmark();
        System.out.println("Unmarked " + index + ".");
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

    public void deleteTask(int index, boolean toDeleteAll) throws InvalidFormatException {
        if (toDeleteAll) {
            tasks.clear();
        } else if (index < 0 || index > tasks.size()) {
            throw new InvalidFormatException();
        }
        tasks.remove(index);
        System.out.println("I've successfully deleted task " + index +
                ". Here are your remaining tasks.");
    }
}
