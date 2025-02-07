package clank.utility;

import clank.command.AddCommand;
import clank.command.ByeCommand;
import clank.command.Command;
import clank.command.DeleteCommand;
import clank.command.ListCommand;
import clank.command.MarkCommand;
import clank.command.SaveCommand;
import clank.command.UnmarkCommand;
import clank.exception.UnknownCommandException;

public class Parser {
    public static Command parse(String input) {
        String[] parts = input.split(" ", 2);
        String mainCommand = parts[0].toLowerCase();

        return switch (mainCommand) {
            case "bye" -> new ByeCommand();
            case "list" -> new ListCommand();
            case "save" -> new SaveCommand();
            case "mark" -> new MarkCommand(input);
            case "unmark" -> new UnmarkCommand(input);
            case "delete" -> new DeleteCommand(input);
            case "todo", "deadline", "event" -> new AddCommand(input);
            default -> throw new UnknownCommandException(mainCommand);
        };
    }
}
