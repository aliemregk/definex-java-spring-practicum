package com.weather.app.exceptions;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.weather.app.constants.Messages;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    protected ResponseEntity<String> handleArgumentExceptions(WebClientResponseException exception) {
        return new ResponseEntity<>(Messages.NOT_FOUND, HttpStatus.BAD_REQUEST);
    }
}
