package com.back.ofertaBack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RequestNotFoundException extends Exception{

    public RequestNotFoundException(Long id) {
        super("Request not found with ID " + id);
    }
}
