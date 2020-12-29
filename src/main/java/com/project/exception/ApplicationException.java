package com.project.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * @author brian
 * @version 1.0
 * @since 05/07/2019
 */


@Getter
@AllArgsConstructor
public class ApplicationException extends RuntimeException {
    private final String code;

    // The message is used when you have a detail message which is difference code
    // The message is only used to log, is wont show to end user
    public ApplicationException(String code, String message) {
        super(message);
        this.code = code;
    }
}
