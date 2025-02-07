package clank.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    @Test
    public void testDeadlineCreation() {
        Deadline deadline = new Deadline("Submit report", "1/3/2025 1800");
        assertEquals("[D][ ] Submit report (by: 1 March 2025, 6:00 pm)", deadline.toString());
    }

    @Test
    public void testSaveFormat() {
        Deadline deadline = new Deadline("Submit report", "1/3/2025 1800");
        assertEquals("D|false|Submit report|1/3/2025 1800", deadline.toSaveFormat());
    }
}
