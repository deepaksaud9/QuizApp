package com.depp.quizapp.handler;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponse {

    private int statusCode;
    private String message;


}
