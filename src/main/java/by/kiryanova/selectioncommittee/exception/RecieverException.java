package by.kiryanova.selectioncommittee.exception;

public class RecieverException extends Exception{
    public RecieverException() {
        super();
    }

    public RecieverException(String message) {
        super(message);
    }

    public RecieverException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecieverException(Throwable cause) {
        super(cause);
    }
}
