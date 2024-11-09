package com.ads.todos.todos_manager.exception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    Logger logger = LoggerFactory.getLogger(GlobalException.class);

    public GlobalException() {
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<String> HandleGlobleException(NullPointerException ex) {
        logger.error("it's null poniter exception from global handler");
        return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
