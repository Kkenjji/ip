package clank.task;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public String getDescription() {
        return description;
    }

    public void mark() {
        this.isDone = true;
    }

    public void unmark() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + getDescription();
    }

    public abstract String toSaveFormat();

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
}
