package com.depp.quizapp.handler;

import com.depp.quizapp.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse> notFoundExceptionHandler(NotFoundException notFoundException){

         ApiResponse apiResponse = new ApiResponse(HttpStatus.BAD_REQUEST.value(), notFoundException.getMessage());
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.BAD_REQUEST);
    }
}
