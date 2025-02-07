package clank.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import clank.exception.ClankException;

public class Deadline extends Task {
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
    private static final DateTimeFormatter OUTPUT_FORMATTER =
            DateTimeFormatter.ofPattern("d MMMM yyyy, h:mm a");

    protected LocalDateTime by;

    public Deadline(String description, String by) {
        super(description);
        try {
            this.by = parseDateTime(by);
        } catch (DateTimeParseException e) {
            throw new ClankException("Error parsing deadline");
        }
    }

    private LocalDateTime parseDateTime(String input) throws DateTimeParseException {
        return LocalDateTime.parse(input, INPUT_FORMATTER);
    }

    @Override
    public String toSaveFormat() {
        return "D|" + isDone + "|" + description + "|" + by.format(INPUT_FORMATTER);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(OUTPUT_FORMATTER) + ")";
    }
}
