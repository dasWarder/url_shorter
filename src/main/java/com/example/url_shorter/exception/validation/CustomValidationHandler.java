package com.example.url_shorter.exception.validation;


import com.example.url_shorter.exception.NullableParamException;
import com.example.url_shorter.exception.ValidationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class CustomValidationHandler {

    @ExceptionHandler(value = {
            ValidationException.class,
            NullableParamException.class
    })
    public ExceptionResponse validateServiceExceptions(Exception e) {

        ExceptionResponse response = ExceptionResponse.builder()
                                                            .type(e.getCause().getClass().getSimpleName())
                                                            .code(400)
                                                            .message(e.getClass().equals(ValidationException.class)?
                                                                                    e.getMessage() : e.getCause().getMessage())
                                                            .build();
        return response;
    }
}
