package com.linuscorp.sbrdemo.prototype;

public class CustomException extends  Exception{
    public CustomException(String message, Throwable err) {
        super(message, err);
    }
}
