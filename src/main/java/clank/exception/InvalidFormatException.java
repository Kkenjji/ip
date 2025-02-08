package clank.exception;

/**
 * Exception thrown when a user inputs a command in an invalid format.
 */
public class InvalidFormatException extends ClankException {

    /**
     * Constructs an {@code InvalidFormatException} with a detailed message about the correct format.
     *
     * @param format The expected format for the command.
     */
    public InvalidFormatException(String format) {
        super("Oh no! The format is wrong!\n"
                + "The correct format for this command is: "
                + format);
    }
}
