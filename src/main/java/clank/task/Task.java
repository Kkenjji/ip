package clank.task;

/**
 * Represents a task in the task list.
 */
public abstract class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a new Task with a given description.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the status icon of the task.
     *
     * @return "X" if the task is done, otherwise a space.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Gets the description of the task.
     *
     * @return The task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Marks the task as done.
     */
    public void mark() {
        this.isDone = true;
    }

    /**
     * Unmarks the task, setting it as not done.
     */
    public void unmark() {
        this.isDone = false;
    }

    /**
     * Converts the task to a string representation.
     *
     * @return The string representation of the task.
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + getDescription();
    }

    /**
     * Converts the task to a format suitable for saving to a file.
     *
     * @return The formatted string for saving.
     */
    public static Task fromSavedFormat(String line) {
        String[] parts = line.split("\\|");

        if (parts.length < 3) {
            System.out.println("Corrupted task.");
            return null;
        }

        try {
            String type = parts[0];
            boolean isDone = Boolean.parseBoolean(parts[1]);
            String description = parts[2];

            Task task = null;
            switch (type) {
            case "T":
                task = new Todo(description);
                break;
            case "D":
                if (parts.length < 4) {
                    System.out.println("Corrupted deadline task. Date is missing.");
                    return null;
                }
                String by = parts[3];
                task = new Deadline(description, by);
                break;
            case "E":
                if (parts.length < 5) {
                    System.out.println("Corrupted event task. Dates are missing.");
                    return null;
                }
                String start = parts[3];
                String end = parts[4];
                task = new Event(description, start, end);
                break;
            default:
                System.out.println("Unknown task type.");
            }

            if (isDone) {
                task.mark();
            }

            return task;
        } catch (Exception e) {
            System.out.println("Corrupted task.");
            return null;
        }
    }

    /**
     * Converts the task into a format suitable for saving to a file.
     * Subclasses must implement this method to define their own save format.
     *
     * @return A formatted string representation of the task for storage.
     */
    public abstract String toSaveFormat();
}
