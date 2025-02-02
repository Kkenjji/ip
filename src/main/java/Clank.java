import java.util.Scanner;

public class Clank {
    private static final String LINE = "____________________________________________________________\n";
    private static final String WELCOME_MESSAGE = " Greetings! I'm Clank, Ratchet's best friend.\n" +
            " I heard you are in trouble, and I'm here to help.\n" +
            " How may I assist you?\n" +
            LINE;
    private static final String BYE_MESSAGE = " Bye. Hope to see you again soon!\n";
    private static final TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            input = scanner.nextLine();
            input = input.toLowerCase();

            String[] splitted = input.split(" ", 2);
            String first = splitted[0];
            String second = (splitted.length == 2) ? splitted[1] : "";

            System.out.println(LINE);

            try {
                switch (first) {
                case "bye":
                    System.out.println(BYE_MESSAGE);
                    System.exit(0);
                    break;
                case "list":
                    taskManager.list();
                    break;
                case "delete":
                    taskManager.deleteTask(second);
                    break;
                case "mark":
                    taskManager.mark(second);
                    break;
                case "unmark":
                    taskManager.unmark(second);
                    break;
                case "todo":
                    taskManager.addTodo(second);
                    break;
                case "deadline":
                    taskManager.addDeadline(second);
                    break;
                case "event":
                    taskManager.addEvent(second);
                    break;
                default:
                    throw new UnknownCommandException(first);
                }
            } catch (ClankException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occured: " + e.getMessage());
            }

            System.out.println(LINE);
        }
    }
}
