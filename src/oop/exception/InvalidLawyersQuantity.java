package oop.exception;

public class InvalidLawyersQuantity extends RuntimeException{

    public InvalidLawyersQuantity(String message) {
        super(message);
    }

    public InvalidLawyersQuantity(String message, Throwable cause) {
        super(message, cause);
    }
}
