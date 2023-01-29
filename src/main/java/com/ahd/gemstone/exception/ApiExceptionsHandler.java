package com.ahd.gemstone.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiBaseException.class)
    public ResponseEntity<ErrorMassage> handelApiException(ApiBaseException exception, WebRequest webRequest) {
        ErrorMassage errorMassage = new ErrorMassage(exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorMassage, exception.getStatusCode());
    }


}
