package clank.command;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import clank.exception.ClankException;

/**
 * Unit tests for the {@code AddCommand} class.
 */
public class AddCommandTest {

    /**
     * Tests the creation of a Todo task using AddCommand.
     */
    @Test
    public void testAddTodoCommand() {
        AddCommand command = new AddCommand("todo Read book");
        assertNotNull(command);
    }

    /**
     * Tests that an invalid AddCommand input throws a {@code ClankException}.
     */
    @Test
    public void testInvalidAddCommand() {
        assertThrows(ClankException.class, () -> new AddCommand("unknown task"));
    }
}
