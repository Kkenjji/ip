package clank.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
