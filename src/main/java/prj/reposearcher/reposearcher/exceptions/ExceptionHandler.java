package prj.reposearcher.reposearcher.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handle(UserNotFoundException exception) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.name(),
                                    exception.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ErrorMessage handle(HttpMediaTypeNotAcceptableException exception) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.name(),
                                    exception.getMessage());
    }

}
