package com.ogutcenali.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

    BAD_REQUEST_ERROR(1201, "Invalid Parameter Input", BAD_REQUEST),
    INTERNAL_ERROR(3000, "Unexpected error on the server", INTERNAL_SERVER_ERROR),
    USER_ALREADY_EXISTS(3004,"Users already exists",BAD_REQUEST),
    RESTAURANT_ALREADY_EXISTS(3005,"Restaurant already exists",BAD_REQUEST);

    private int code;
    private String message;
    private HttpStatus httpStatus;
}
