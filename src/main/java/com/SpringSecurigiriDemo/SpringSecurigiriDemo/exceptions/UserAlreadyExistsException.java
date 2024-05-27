package com.SpringSecurigiriDemo.SpringSecurigiriDemo.exceptions;

import com.SpringSecurigiriDemo.SpringSecurigiriDemo.exceptions.errors.Error;

public class UserAlreadyExistsException extends RuntimeException {
    private Error error;

    public UserAlreadyExistsException(Error error) {
        super(error.getMessage());
        this.error = error;
    }

    @Override
    public String toString() {
        return super.toString() + " Error: " + error.getError() + " Status: " + error.getStatus() + " Path: " + error.getPath();
    }
}