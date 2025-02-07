package clank.exception;

/**
 * Represents the base exception class for errors in the Clank chatbot.
 */
public class ClankException extends RuntimeException {

    /**
     * Constructs a {@code ClankException} with a specified error message.
     *
     * @param message The detailed error message.
     */
    public ClankException(String message) {
        super(message);
    }
}
