package clank.task;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EventTest {
    @Test
    public void testEventCreation() {
        Event event = new Event("Team meeting", "1/3/2025 1000", "2/3/2025 1200");
        assertEquals("[E][ ] Team meeting (from: 1 March 2025, 10:00 am to: 2 March 2025, 12:00 pm)",
                event.toString());
    }

    @Test
    public void testSaveFormat() {
        Event event = new Event("Team meeting", "1/3/2025 1000", "2/3/2025 1200");
        assertEquals("T|false|Team meeting|1/3/2025 1000|2/3/2025 1200", event.toSaveFormat());
    }
}
