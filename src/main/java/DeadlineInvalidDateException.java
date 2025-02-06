public class DeadlineInvalidDateException extends ClankException {
    public DeadlineInvalidDateException(String command) {
        super("A deadline is required! Please enter the date using this \"/by yyyy-mm-dd HHmm\" " +
                "format after the description for \"" + command + "\".");
    }
}
