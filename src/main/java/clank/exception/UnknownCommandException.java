package clank.exception;

public class UnknownCommandException extends ClankException {
    public UnknownCommandException(String command) {
        super("Hmm, I have not seen \"" + command + "\" before! Please try another command that I understand.");
    }
}
