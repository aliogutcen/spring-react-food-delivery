package com.ogutcenali.exception;

import lombok.Getter;

@Getter
public class RegisterException extends RuntimeException {
    private final ErrorType ErrorType;

    public RegisterException(ErrorType ErrorType) {
        super(ErrorType.getMessage());
        this.ErrorType = ErrorType;
    }
    public RegisterException(ErrorType ErrorType, String message) {
        super(message);
        this.ErrorType = ErrorType;
    }
}
