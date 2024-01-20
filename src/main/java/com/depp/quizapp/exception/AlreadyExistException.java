package com.depp.quizapp.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data

public class AlreadyExistException extends RuntimeException {

    private int statusCode;
    private String message;

    public AlreadyExistException(String message){
        super(message);
    }
}
