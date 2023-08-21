package com.cc.bookmanager.exception;

public class InvalidPasswordFormatException extends MasterException {
    public InvalidPasswordFormatException(String message) {
        super(message, ExceptionCode.PASSWORD_INVALID);
    }
}
