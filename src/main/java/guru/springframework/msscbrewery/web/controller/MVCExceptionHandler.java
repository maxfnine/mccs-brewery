package guru.springframework.msscbrewery.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MVCExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException exception){
        List<String> errors=new ArrayList<>(exception.getConstraintViolations().size());
        exception.getConstraintViolations().forEach(violation -> errors.add(violation.getPropertyPath()+" "+violation.getMessage()));
        return new ResponseEntity<List>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<List> handleBindException(BindException exception){
        return new ResponseEntity<>(exception.getAllErrors(),HttpStatus.BAD_REQUEST);
    }
}
