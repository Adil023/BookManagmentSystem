package library.service;

public class InvalidValueException extends Exception {
    public InvalidValueException(String message) {
        super(message);
    }
}