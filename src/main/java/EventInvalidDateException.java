public class EventInvalidDateException extends ClankException {
    public EventInvalidDateException(String command) {
        super("A start and end date/time is required! Please add \"/3pm /5pm\" " +
                "after the description for \"" + command + "\".");
    }
}
