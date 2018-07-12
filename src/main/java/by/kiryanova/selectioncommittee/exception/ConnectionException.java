package by.kiryanova.selectioncommittee.exception;

public class ConnectionException extends Exception{
    public ConnectionException() {}
    public ConnectionException(String m) {
        super(m);
    }
    public ConnectionException(Throwable th) {
        super(th);
    }
    public ConnectionException(String m, Throwable th) {
        super(m, th);
    }
    public ConnectionException(String m, Throwable th, boolean suppression, boolean stackTrace) {
        super(m, th, suppression, stackTrace);
    }
}
