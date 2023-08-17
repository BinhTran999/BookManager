package com.cc.bookmanager.exception;
public class ExistedException extends MasterException {
    public ExistedException(String message) {
        super(message, ExceptionCode.CODE_EXISTED);
    }
}
