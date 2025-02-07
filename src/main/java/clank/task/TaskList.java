package clank.task;

import java.util.ArrayList;

import clank.exception.InvalidFormatException;

/**
 * Represents a list of tasks.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructs a TaskList with a given list of tasks.
     *
     * @param tasks The list of tasks.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Retrieves the list of tasks.
     *
     * @return The list of tasks.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Adds a new task to the list.
     *
     * @param task The task to add.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Lists all tasks in the task list.
     */
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

    /**
     * Marks the task at the specified index as done.
     *
     * @param index The index of the task to mark as done (zero-based index).
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public void mark(int index) throws IndexOutOfBoundsException {
        if ((index < 0) || (index > (tasks.size() - 1))) {
            throw new IndexOutOfBoundsException();
        }
        tasks.get(index).mark();
        System.out.println("Marked " + (index + 1) + " as done.");
    }

    /**
     * Unmarks the task at the specified index, setting it as not done.
     *
     * @param index The index of the task to unmark (zero-based index).
     * @throws IndexOutOfBoundsException If the index is out of range.
     */
    public void unmark(int index) throws IndexOutOfBoundsException {
        if ((index < 0) || (index > (tasks.size() - 1))) {
            throw new IndexOutOfBoundsException();
        }
        tasks.get(index).unmark();
        System.out.println("Unmarked " + (index + 1) + ".");
    }

    /**
     * Deletes a task from the task list at the specified index, or clears all tasks if specified.
     *
     * @param index The index of the task to delete (zero-based index).
     * @param toDeleteAll If true, deletes all tasks in the list.
     * @throws InvalidFormatException If an invalid format is encountered.
     * @throws IndexOutOfBoundsException If the index is out of range when deleting a single task.
     */
    public void deleteTask(int index, boolean toDeleteAll) throws IndexOutOfBoundsException {
        if (toDeleteAll) {
            tasks.clear();
        } else if ((index < 0) || (index > (tasks.size() - 1))) {
            throw new IndexOutOfBoundsException();
        }
        tasks.remove(index);
        System.out.println("I've successfully deleted task " + (index + 1)
                + ". Here are your remaining tasks.");
        listTasks();
    }

    /**
     * Finds and returns a list of tasks that contain the specified keyword in their description.
     *
     * @param keyword The keyword to search for within task descriptions.
     * @return An {@code ArrayList} of tasks that match the given keyword.
     */
    public ArrayList<Task> findTasks(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (Task task : tasks) {
            String description = task.getDescription();
            if (description.contains(keyword)) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }
}
