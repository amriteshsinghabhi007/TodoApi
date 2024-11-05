package com.ads.todos.todos_manager.exception;
import org.springframework.http.HttpStatus;

public class ExceptionResponse {
    private String message;
    private boolean success;
    private HttpStatus status;

    public ExceptionResponse(String message, boolean success, HttpStatus status) {
        this.message = message;
        this.success = success;
        this.status = status;
    }

    public ExceptionResponse() {
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
