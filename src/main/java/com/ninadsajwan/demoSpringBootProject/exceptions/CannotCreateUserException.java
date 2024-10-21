package com.ninadsajwan.demoSpringBootProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Cannot create user")
public class CannotCreateUserException extends RuntimeException {
}
