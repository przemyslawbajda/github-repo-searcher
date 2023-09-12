package prj.reposearcher.reposearcher.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message, Throwable ex) {
        super(message, ex);
    }
}
