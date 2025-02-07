package clank.exception;

/**
 * Exception thrown when a user inputs an unrecognized command.
 */
public class UnknownCommandException extends ClankException {

    /**
     * Constructs an {@code UnknownCommandException} with a message indicating the invalid command.
     *
     * @param command The unrecognized command entered by the user.
     */
    public UnknownCommandException(String command) {
        super("Hmm, I have not seen \"" + command + "\" before! Please try another command that I understand.");
    }
}
