package com.cc.bookmanager.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionCode {
    SUCCESS("MDS-000", "Success"),
    INVALID_PARAMETER("MDS-001", "Invalid parameter"),
    NOT_FOUND("MDS-002", "Entity Not Found"),
    EXTERNAL_SERVICE_SERVER_ERROR("MDS-003", "External service error"),
    TOKEN_EXPIRED("MDS-004", "Token expired"),
    FORBIDDEN("MDS-005", "Forbidden"),
    UNAUTHORIZED("MDS-006", "UNAUTHORIZED"),
    ERR_MAX_UPLOAD_SIZE("MDS-007", "Max upload size file invalid"), CODE_EXISTED("MDS-008", "Code existed"),
    EMAIL_INVALID("MDS-009", "Email invalid"), PASSWORD_INVALID("MDS-010", "Password invalid");
    private final String code;
    private final String detail;
}
