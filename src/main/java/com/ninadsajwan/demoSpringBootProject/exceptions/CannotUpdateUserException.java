package com.ninadsajwan.demoSpringBootProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CannotUpdateUserException extends RuntimeException {

    public CannotUpdateUserException(UUID id) {
        super("User not found with id: " + id);
    }
}
