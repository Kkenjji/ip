package clank.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TodoTest {
    @Test
    public void testTodoCreation() {
        Todo todo = new Todo("Buy groceries");
        assertEquals("[T][ ] Buy groceries", todo.toString());
    }

    @Test
    public void testSaveFormat() {
        Todo todo = new Todo("Buy groceries");
        assertEquals("T|false|Buy groceries", todo.toSaveFormat());
    }
}
