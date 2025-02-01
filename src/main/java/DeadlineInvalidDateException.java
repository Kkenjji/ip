public class DeadlineInvalidDateException extends ClankException {
    public DeadlineInvalidDateException(String command) {
        super("A deadline is required! Please add \"/20th May\" " +
                "after the description for \"" + command + "\".");
    }
}
