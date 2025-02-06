import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task {
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private static final DateTimeFormatter OUTPUT_FORMATTER =
            DateTimeFormatter.ofPattern("d MMMM yyyy, h:mm a");

    protected LocalDateTime start;
    protected LocalDateTime end;

    public Event(String description, String start, String end) {
        super(description);
        try {
            this.start = parseDateTime(start);
            this.end = parseDateTime(end);
        } catch (DateTimeParseException e) {
            throw new ClankException("Error parsing event");
        }
    }

    private LocalDateTime parseDateTime(String input) throws DateTimeParseException {
        return LocalDateTime.parse(input, INPUT_FORMATTER);
    }

    @Override
    public String toSaveFormat() {
        return "T|" + isDone + "|" + description
                + "|" + start.format(INPUT_FORMATTER) + "|" + end.format(INPUT_FORMATTER);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + start.format(OUTPUT_FORMATTER)
                + " to: " + end.format(OUTPUT_FORMATTER) + ")";
    }
}
