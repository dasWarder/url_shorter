package com.example.url_shorter.util;

import org.apache.commons.validator.ValidatorException;
import org.apache.commons.validator.routines.UrlValidator;

import java.util.Arrays;

import static org.springframework.util.Assert.notNull;

public class UrlValidation {


    public static void validateUrl(String url) throws ValidatorException {
        notNull(url, "The url must be not null");

        final UrlValidator urlValidator = new UrlValidator(new String[]{"http", "https"});

        if(!urlValidator.isValid(url)) {
            throw new ValidatorException(
                                        String.format("Provided URL:%s is not valid", url));
        }
    }

    public static <T> void validateObject(T ... objects){
        Arrays.stream(objects).forEach(obj -> notNull(obj, "Param must be not null"));
    }
}
