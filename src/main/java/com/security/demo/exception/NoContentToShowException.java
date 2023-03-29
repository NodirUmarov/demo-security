package com.security.demo.exception;

public class NoContentToShowException extends RuntimeException {

    public NoContentToShowException() {
    }

    public NoContentToShowException(String message) {
        super(message);
    }
}
