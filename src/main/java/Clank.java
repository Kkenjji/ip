import java.util.ArrayList;
import java.util.Scanner;

public class Clank {
    private static final String LINE = "____________________________________________________________\n";
    private static final String WELCOME_MESSAGE = " Greetings! I'm Clank, Ratchet's best friend.\n"
                + " I heard you are in trouble, and I'm here to help.\n"
                + " How may I assist you?\n"
                + LINE;
    private static final String BYE_MESSAGE = " Bye. Hope to see you again soon!\n";
    private static final String FILE_PATH = "./data/clank.txt";
    private static TaskManager taskManager = null;
    private static final Storage storage = new Storage(FILE_PATH);

    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);

        Scanner scanner = new Scanner(System.in);
        String input;
        ArrayList<Task> tasks = storage.loadTasks();
        taskManager = new TaskManager(tasks);

        while (true) {
            input = scanner.nextLine();
            String[] splitted = input.split(" ", 2);
            String mainCommand = splitted[0].toLowerCase();
            String details = (splitted.length == 2) ? splitted[1] : "";

            System.out.println(LINE);

            try {
                switch (mainCommand) {
                case "bye":
                    scanner.close();
                    System.out.println(BYE_MESSAGE);
                    break;
                case "list":
                    taskManager.listTasks();
                    break;
                case "save":
                    storage.saveTasks(tasks);
                    System.out.println("Saved successfully!");
                    break;
                case "delete":
                    taskManager.deleteTask(details);
                    break;
                case "mark":
                    taskManager.mark(details);
                    break;
                case "unmark":
                    taskManager.unmark(details);
                    break;
                case "todo":
                    taskManager.addTodo(details);
                    break;
                case "deadline":
                    taskManager.addDeadline(details);
                    break;
                case "event":
                    taskManager.addEvent(details);
                    break;
                default:
                    throw new UnknownCommandException(mainCommand);
                }
            } catch (ClankException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }

            System.out.println(LINE);
        }
    }
}
