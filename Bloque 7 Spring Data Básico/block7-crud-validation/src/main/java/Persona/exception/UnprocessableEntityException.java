package Persona.exception;

public class UnprocessableEntityException extends RuntimeException{
    public UnprocessableEntityException(String msg) {
        super(msg);
    }
}
