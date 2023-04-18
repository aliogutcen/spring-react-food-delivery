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
    AUTH_PASSWORD_ERROR(1301, "The passwords you entered do not match!", BAD_REQUEST),
    AUTH_LOGIN_ERROR(1303, "Username or password is incorrect", BAD_REQUEST),
    TOKEN_ERROR(3001, "An error occurred during token creation", INTERNAL_SERVER_ERROR),
    TOKEN_DECODE_ERROR(3002, "No user of the token found", INTERNAL_SERVER_ERROR),
    AUTH_NOT_FOUND_ID(3003,"Not found ID ",NOT_FOUND),
    AUTH_NOT_ACTIVATED(3004,"Auth Not activated ",BAD_REQUEST),
    AUTH_ALREADY_EXISTS(3004,"Auth already exists",BAD_REQUEST);


    private int code;
    private String message;
    private HttpStatus httpStatus;
}
