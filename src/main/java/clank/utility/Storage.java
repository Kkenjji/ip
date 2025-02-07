package clank.utility;

import clank.exception.ClankException;
import clank.task.Task;
import clank.task.TaskList;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles loading and saving tasks to a file
 */
public class Storage {
    private final String filePath;

    /**
     * Constructs a new Storage object with the specified file path.
     *
     * @param filePath The file path where tasks are stored.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Saves the given task list to a file.
     *
     * @param taskList The list of tasks to save.
     * @throws ClankException If an error occurs while saving.
     */
    public void saveTasks(TaskList taskList) throws ClankException {
        ArrayList<Task> tasks = taskList.getTasks();
        try {
            File file = new File(filePath);
            File directory = file.getParentFile();

            if (directory != null && !directory.exists()) {
                directory.mkdirs();
            }

            FileWriter fw = new FileWriter(filePath);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Task task : tasks) {
                bw.write(task.toSaveFormat());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            throw new ClankException("Failed to save tasks.");
        }
    }

    /**
     * Loads tasks from the file into an ArrayList.
     *
     * @return A list of tasks loaded from the file.
     * @throws ClankException If an error occurs while loading tasks.
     */
    public ArrayList<Task> loadTasks() throws ClankException {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                return tasks;
            }

            Scanner scanner = new Scanner(file);
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                Task task = Task.fromSavedFormat(line);
                if (task != null) {
                    tasks.add(task);
                }
            }
            scanner.close();
        } catch (IOException e) {
            throw new ClankException("Failed to load tasks.");
        }
        return tasks;
    }
}
