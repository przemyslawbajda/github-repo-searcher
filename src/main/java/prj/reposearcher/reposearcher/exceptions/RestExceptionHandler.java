package prj.reposearcher.reposearcher.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handle(UserNotFoundException exception) {
        return new ErrorMessage(HttpStatus.NOT_FOUND.name(),
                                    exception.getMessage() + " (" + exception.getCause().getMessage() + ")");
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ResponseEntity<ErrorMessage> handle(HttpMediaTypeNotAcceptableException exception) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.name(),
                "Failed to download repositories info: XML not acceptable (" + exception.getMessage() +")");

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .contentType(MediaType.APPLICATION_JSON)
                .body(message);
    }
}
