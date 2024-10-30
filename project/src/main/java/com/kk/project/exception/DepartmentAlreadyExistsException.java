package com.kk.project.exception;

public class DepartmentAlreadyExistsException extends RuntimeException {
    public DepartmentAlreadyExistsException(String msg) {
        super(msg);
    }
}
