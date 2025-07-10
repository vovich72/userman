package com.github.bvb7.userman.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ErrorHandlingControllerAdvice {

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> detaExceptionHandler(final Exception exception,
                                               final HttpServletRequest request) {
        ApiError error = new ApiError(HttpStatus.NO_CONTENT, exception.getLocalizedMessage());
        error.setPath(request.getRequestURI());

        return new ResponseEntity<>(error, HttpStatus.NO_CONTENT);
    }

}
