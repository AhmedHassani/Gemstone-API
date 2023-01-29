package com.ahd.gemstone.exception;

import org.springframework.http.HttpStatus;

public class BadRequest extends ApiBaseException {

    public BadRequest(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.BAD_REQUEST;
    }
}
