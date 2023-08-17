package com.cc.bookmanager.exception;

import lombok.Getter;

@Getter
public class MasterException extends RuntimeException {
    protected final ExceptionCode exceptionCode;
    protected final String detailMessage;

    public MasterException(String message, ExceptionCode exceptionCode) {
        this.detailMessage = message;
        this.exceptionCode = exceptionCode;
    }

    @Override
    public String toString() {
        return exceptionCode.getDetail() + ": " + detailMessage;
    }
}
