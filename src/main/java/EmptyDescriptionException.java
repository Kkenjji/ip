public class EmptyDescriptionException extends ClankException {
    public EmptyDescriptionException(String command) {
        super("Oops! You have to specify the description for \"" + command +
                    "\". Maybe something like \"read book A\".");
    }
}
