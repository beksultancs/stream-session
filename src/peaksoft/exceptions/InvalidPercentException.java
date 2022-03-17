package peaksoft.exceptions;

/**
 * @author Beksultan
 */
public class InvalidPercentException extends RuntimeException {
    public InvalidPercentException() {
    }

    public InvalidPercentException(String message) {
        super(message);
    }
}
