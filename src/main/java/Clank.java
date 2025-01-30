import java.util.Scanner;
import java.util.ArrayList;

public class Clank {
    private static TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        String line = "____________________________________________________________\n";
        String welcomeMessage = " Greetings! I'm Clank, Ratchet's best friend.\n" +
                " I heard you are in trouble, and I'm here to help.\n" +
                " How may I assist you?\n" +
                line;

        String byeMessage = " Bye. Hope to see you again soon!\n";
        System.out.println(welcomeMessage);

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            input = scanner.nextLine();
            input = input.toLowerCase();
            String[] splitted = input.split(" ", 2);
            String first = splitted[0];
            String second = "";
            if (splitted.length == 2) {
                second = splitted[1];
            }

            System.out.println(line);

            switch (first) {
            case "bye":
                System.out.println(byeMessage);
                break;
            case "list":
                taskManager.list();
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
            }

            System.out.println(line);
        }
    }
}
