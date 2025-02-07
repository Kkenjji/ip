package clank.command;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import clank.exception.ClankException;

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
}
