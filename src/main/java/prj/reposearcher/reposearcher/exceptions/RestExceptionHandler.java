package prj.reposearcher.reposearcher.coderepository;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import prj.reposearcher.reposearcher.exceptions.ErrorMessage;
import prj.reposearcher.reposearcher.exceptions.UserNotFoundException;


@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handle(UserNotFoundException exception) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.name(),
                                    exception.getMessage());
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage handle(HttpMediaTypeNotAcceptableException exception) {
        return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.name(),
                                    exception.getMessage());
    }

}
