import java.util.Scanner;
import java.util.ArrayList;

public class Clank {
    private static ArrayList<Task> tasks = new ArrayList<>();

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

            System.out.println(line);

            switch (input) {
            case "bye":
                System.out.println(byeMessage);
                break;
            case "list":
                for (int i = 0; i < tasks.size(); i++) {
                    int index = i + 1;
                    Task t = tasks.get(i);
                    System.out.println(index + ".[" + t.getStatusIcon() + "] " + t.getDescription());
                }
                break;
            default:
                if (input.startsWith("mark ")) {
                    String[] splitted = input.split(" ");
                    if (splitted.length == 2) {
                        int taskIndex = Integer.parseInt(splitted[1]);
                        tasks.get(taskIndex - 1).mark();
                        System.out.println("Marked " + taskIndex + " as done.");
                    }
                } else if (input.startsWith("unmark ")) {
                    String[] splitted = input.split(" ");
                    if (splitted.length == 2) {
                        int taskIndex = Integer.parseInt(splitted[1]);
                        tasks.get(taskIndex - 1).unmark();
                        System.out.println("Unmarked " + taskIndex + ".");
                    }
                } else {
                    Task t = new Task(input);
                    tasks.add(t);
                    System.out.println("added: " + input);
                }
            }

            System.out.println(line);
        }
    }
}
