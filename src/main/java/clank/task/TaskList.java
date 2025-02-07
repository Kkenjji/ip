package clank.task;

import java.util.ArrayList;

import clank.exception.InvalidFormatException;

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

    public void mark(int index) {
        if ((index < 0) || (index > (tasks.size() - 1))) {
            throw new IndexOutOfBoundsException();
        }
        tasks.get(index).mark();
        System.out.println("Marked " + (index + 1) + " as done.");
    }

    public void unmark(int index) {
        if ((index < 0) || (index > (tasks.size() - 1))) {
            throw new IndexOutOfBoundsException();
        }
        tasks.get(index).unmark();
        System.out.println("Unmarked " + (index + 1) + ".");
    }

    public void deleteTask(int index, boolean toDeleteAll) throws InvalidFormatException {
        if (toDeleteAll) {
            tasks.clear();
        } else if ((index < 0) || (index > (tasks.size() - 1))) {
            throw new IndexOutOfBoundsException();
        }
        tasks.remove(index);
        System.out.println("I've successfully deleted task " + (index + 1) +
                ". Here are your remaining tasks.");
        listTasks();
    }
}
