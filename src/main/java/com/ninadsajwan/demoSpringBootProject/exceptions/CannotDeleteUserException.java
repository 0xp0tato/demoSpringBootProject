package com.ninadsajwan.demoSpringBootProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class CannotDeleteUserException extends RuntimeException {

    public CannotDeleteUserException(UUID id) {
        super("No user found with id:" + id);
    }

}
