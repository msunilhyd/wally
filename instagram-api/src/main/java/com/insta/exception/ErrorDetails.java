package com.insta.exception;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class ErrorDetails {

    private String message;
    private String details;
    private LocalDateTime timestamp;
}
