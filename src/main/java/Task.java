public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public abstract String toSaveFormat();

    public static Task fromSavedFormat(String data) {
        String[] parts = data.split("\\|");
        String type = parts[0];
        boolean isDone = Boolean.parseBoolean(parts[1]);
        String description = parts[2];
        switch (type) {
        case "T":
            Task todo = new Todo(description);
            if (isDone) {
                todo.mark();
            }
            return todo;
        case "D":
            String by = parts[3];
            Task deadline = new Deadline(description, by);
            if (isDone) {
                deadline.mark();
            }
            return deadline;
        case "E":
            String start = parts[3];
            String end = parts[4];
            Task event = new Event(description, start, end);
            if (isDone) {
                event.mark();
            }
            return event;
        default:
            return null;
        }
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
}
