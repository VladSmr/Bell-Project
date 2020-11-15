package com.bell.project.controller;

import com.bell.project.view.ErrorView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;

@RestControllerAdvice
public class ControllersAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class, NoResultException.class})
    protected ResponseEntity<ErrorView> handleEntityNotFoundException() {
        return new ResponseEntity<>(new ErrorView("There is no such entity in database"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({NullPointerException.class})
    protected ResponseEntity<ErrorView> handleNullPointerException() {
        return new ResponseEntity<>(new ErrorView("Check the correct input data"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({org.hibernate.exception.ConstraintViolationException.class})
    protected ResponseEntity<ErrorView> handleConstraintViolationException() {
        return new ResponseEntity<>(new ErrorView("Entity with provided ID not found"), HttpStatus.NOT_FOUND);
    }
}