package clank.command;

import clank.exception.ClankException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddCommandTest {
    @Test
    public void testAddTodoCommand() {
        AddCommand command = new AddCommand("todo Read book");
        assertNotNull(command);
    }

    @Test
    public void testInvalidAddCommand() {
        assertThrows(ClankException.class, () -> new AddCommand("unknown task"));
    }

    @Test
    public void testEmptyDescription() {
        assertThrows(clank.exception.EmptyDescriptionException.class, () -> new AddCommand("todo "));
    }
}
