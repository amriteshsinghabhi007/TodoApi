package com.ads.todos.todos_manager.exception;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundEx extends RuntimeException {
    private String message;
    private HttpStatus status;

    public ResourceNotFoundEx(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public ResourceNotFoundEx() {
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
