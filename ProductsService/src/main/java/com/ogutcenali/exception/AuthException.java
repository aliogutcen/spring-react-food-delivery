package com.ogutcenali.exception;

import lombok.Getter;

@Getter
public class AuthException extends RuntimeException {
    private final ErrorType ErrorType;

    public AuthException(ErrorType ErrorType) {
        super(ErrorType.getMessage());
        this.ErrorType = ErrorType;
    }
    public AuthException(ErrorType ErrorType, String message) {
        super(message);
        this.ErrorType = ErrorType;
    }
}
