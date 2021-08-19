package com.example.url_shorter.util;

import com.example.url_shorter.exception.NullableParamException;
import com.example.url_shorter.exception.ValidationException;
import org.apache.commons.validator.ValidatorException;
import org.apache.commons.validator.routines.UrlValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.util.Assert.notNull;

public class UrlValidation {


    public static void validateUrl(String url) throws ValidationException {
        notNull(url, "The url must be not null");

        final UrlValidator urlValidator = new UrlValidator(new String[]{"http", "https"});

        if(!urlValidator.isValid(url)) {
            throw new ValidationException(
                                        String.format("Provided URL:%s is not valid", url));
        }
    }

    public static <T> void validateObject(T ... objects) throws NullableParamException {
        List<Boolean> nonValidFields = Arrays.stream(objects)
                .map(obj -> Objects.nonNull(obj))
                .filter(obj -> obj == false)
                .collect(Collectors.toList());

        if(!nonValidFields.isEmpty()) {
            throw new NullableParamException("The input param(s) is/are nullable");
        }
    }
}
