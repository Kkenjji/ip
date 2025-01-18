import java.util.Scanner;
import java.util.ArrayList;

public class Clank {
    private static ArrayList<String> messages = new ArrayList<>();

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

            if (input.equalsIgnoreCase("bye")) {
                System.out.println(byeMessage);
                break;
            } else if (input.equalsIgnoreCase("list")) {
                for (int i = 0; i < messages.size(); i++) {
                    int index = i + 1;
                    System.out.println(index + ". " + messages.get(i));
                }
            } else {
                messages.add(input);
                System.out.println("added: " + input);
            }

            System.out.println(line);
        }
    }
}
