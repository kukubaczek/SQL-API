package pl.themolka.sql.exception;

public class PrimaryKeyNotDefinedException extends RuntimeException {
    public PrimaryKeyNotDefinedException() {
        super();
    }
    
    public PrimaryKeyNotDefinedException(String message) {
        super(message);
    }
    
    public PrimaryKeyNotDefinedException(Throwable cause) {
        super(cause);
    }
    
    public PrimaryKeyNotDefinedException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
