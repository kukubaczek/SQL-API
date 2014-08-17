package pl.themolka.sql.exception;

public class SizeTypeException extends RuntimeException {
    public SizeTypeException() {
        super();
    }
    
    public SizeTypeException(String message) {
        super(message);
    }
    
    public SizeTypeException(Throwable cause) {
        super(cause);
    }
    
    public SizeTypeException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
