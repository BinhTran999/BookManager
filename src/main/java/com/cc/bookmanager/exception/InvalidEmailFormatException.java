package com.cc.bookmanager.exception;

public class InvalidEmailFormatException extends MasterException {
    public InvalidEmailFormatException(String message) {
        super(message, ExceptionCode.EMAIL_INVALID);
    }
}