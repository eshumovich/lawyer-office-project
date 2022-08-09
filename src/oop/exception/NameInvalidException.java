package oop.exception;

public class NameInvalidException extends Exception {

    public NameInvalidException(String message) {
        super(message);
    }

    public NameInvalidException(String message, Throwable cause) {
        super(message, cause);
    }
}
