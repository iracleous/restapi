package gr.athtech.restapi.exception;

public class ValidationException extends Exception{
    public ValidationException(String message){
        super(message);
    }

}