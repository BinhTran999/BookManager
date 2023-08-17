package com.cc.bookmanager.exception;

import com.cc.bookmanager.dto.base.simple.response.ApiBaseResponse;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import static com.cc.bookmanager.exception.ExceptionCode.*;


@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiBaseResponse argumentExeception(Exception ex, WebRequest request) {
        return new ApiBaseResponse(INVALID_PARAMETER.getCode(), INVALID_PARAMETER.getDetail());
    }

    @ExceptionHandler({NotFoundException.class, NullPointerException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ApiBaseResponse notFoundException(Exception ex, WebRequest request) {
        return new ApiBaseResponse(NOT_FOUND.getCode(), NOT_FOUND.getDetail());
    }

    @ExceptionHandler(MasterException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiBaseResponse masterException(MasterException ex, WebRequest request) {
        return new ApiBaseResponse(CODE_EXISTED.getCode(), ex.toString());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiBaseResponse globalExceptionHandler(Exception ex, WebRequest request) {
        return new ApiBaseResponse(EXTERNAL_SERVICE_SERVER_ERROR.getCode(), EXTERNAL_SERVICE_SERVER_ERROR.getDetail());
    }
}
