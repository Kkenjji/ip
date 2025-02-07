package clank.utility;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import clank.command.AddCommand;
import clank.command.ByeCommand;
import clank.command.Command;
import clank.command.ListCommand;
import clank.exception.UnknownCommandException;

public class ParserTest {
    @Test
    public void testParseByeCommand() {
        Command command = Parser.parse("bye");
        assertTrue(command instanceof ByeCommand);
    }

    @Test
    public void testParseListCommand() {
        Command command = Parser.parse("list");
        assertTrue(command instanceof ListCommand);
    }

    @Test
    public void testParseAddCommand() {
        Command command = Parser.parse("todo Read book");
        assertTrue(command instanceof AddCommand);
    }

    @Test
    public void testParseUnknownCommand() {
        assertThrows(UnknownCommandException.class, () -> Parser.parse("unknownCommand"));
    }
}
