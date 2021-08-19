package com.example.url_shorter.exception;

public class NullableParamException extends Throwable {

    public NullableParamException() {
    }

    public NullableParamException(String message) {
        super(message);
    }

    public NullableParamException(String message, Throwable cause) {
        super(message, cause);
    }
}
