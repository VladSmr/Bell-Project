package com.bell.project.controller;

import com.bell.project.Data;
import com.bell.project.view.ErrorView;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import java.util.UUID;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler implements ResponseBodyAdvice<Object> {

    private static final Logger log = LoggerFactory.getLogger(ControllerAdvice.class);

    @ExceptionHandler({Exception.class})
    protected ResponseEntity<ErrorView> exception(Exception ex) {
        UUID uuid = UUID.randomUUID();

        if (ex.getCause().getClass() == ConstraintViolationException.class) {
            String constraintViolationException = "Entity with provided ID not found. UUID: ";
            log.warn(constraintViolationException + uuid, ex);
            return new ResponseEntity<>(new ErrorView(constraintViolationException + uuid), HttpStatus.NOT_FOUND);
        } else if (ex.getCause().getClass() == EntityNotFoundException.class || ex.getCause().getClass() == NoResultException.class) {
            String noEntity = "There is no such entity in database. UUID: ";
            log.warn(noEntity + uuid, ex);
            return new ResponseEntity<>(new ErrorView(noEntity + uuid), HttpStatus.NOT_FOUND);
        } else if (ex.getCause().getClass() == MethodArgumentNotValidException.class) {
            String invalidArg = "No valid arguments. UUID: ";
            log.warn(invalidArg + uuid, ex);
            return new ResponseEntity<>(new ErrorView(invalidArg + uuid), HttpStatus.BAD_REQUEST);
        } else {
            String internalError = "There is a problem. Try again. UUID: ";
            log.error(internalError + uuid, ex);
            return new ResponseEntity<>(new ErrorView(internalError + uuid), HttpStatus.INTERNAL_SERVER_ERROR);
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