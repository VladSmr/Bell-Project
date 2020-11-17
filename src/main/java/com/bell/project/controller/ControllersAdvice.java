package com.bell.project.controller;

import com.bell.project.Data;
import com.bell.project.view.ErrorView;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;

@RestControllerAdvice
public class ControllersAdvice extends ResponseEntityExceptionHandler implements ResponseBodyAdvice<Object> {

    @ExceptionHandler({Exception.class})
    protected ResponseEntity<ErrorView> exception(Exception ex) {
        if (ex.getCause().getClass() == ConstraintViolationException.class) {
            return new ResponseEntity<>(new ErrorView("Entity with provided ID not found"), HttpStatus.NOT_FOUND);
        } else if (ex.getCause().getClass() == EntityNotFoundException.class || ex.getCause().getClass() == NoResultException.class) {
            return new ResponseEntity<>(new ErrorView("There is no such entity in database"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new ErrorView("There is exception " + ex), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
                                  Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o == null) {
            o = "success";
        }
        if (o.getClass() == ErrorView.class) {
            return o;
        }
        return new Data<>(o);
    }
}