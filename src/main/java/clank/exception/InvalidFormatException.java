package clank.exception;

public class InvalidFormatException extends ClankException {
    public InvalidFormatException(String format) {
        super("Oh no! The format is wrong! "
                + "The correct format for this command is: "
                + format);
    }
}
