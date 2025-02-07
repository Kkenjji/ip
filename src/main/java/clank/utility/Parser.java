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

        switch (mainCommand) {
        case "bye":
            return new ByeCommand();
        case "list":
            return new ListCommand();
        case "save":
            return new SaveCommand();
        case "mark":
            return new MarkCommand(input);
        case "unmark":
            return new UnmarkCommand(input);
        case "delete":
            return new DeleteCommand(input);
        case "todo", "deadline", "event":
            return new AddCommand(input);
        default:
            throw new UnknownCommandException(mainCommand);
        }
    }
}
