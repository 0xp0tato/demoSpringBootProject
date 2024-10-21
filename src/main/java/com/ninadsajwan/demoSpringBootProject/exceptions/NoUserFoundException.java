package com.ninadsajwan.demoSpringBootProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No user present in DB")
public class NoUserFoundException extends RuntimeException {
}
