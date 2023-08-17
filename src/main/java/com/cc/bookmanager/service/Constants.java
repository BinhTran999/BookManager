package com.cc.bookmanager.service;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Constants {
    public static final String EXCEPTION_MES = "Dịch vụ tạm thời gián đoạn, bạn vui lòng thực hiện lại sau ít phút.";
    public static final String SUCCESS = "SUCCESS";

    public Constants() {
        throw new IllegalStateException("Utility class");
    }

    public interface ResponseCode {
        String SUCCESS = "00";
        String AccessDenied = "01";
        String VALIDATE_FILE = "11";
        String FILE_UPLOAD_NOTMAP_TO_HOSO = "12";
        String INVALID_DURATION = "100002";
        String NOT_FOUND = "100003";
        String KAFKA_SEND_FAILURE = "9903";
        String REVERT_FAILURE = "9904";
        String FAILURE = "9901";
        String EXCEPTION_ERROR = "9902";
        String CONNECTION_TIMEOUT = "10501";
        String REQUEST_TIMEOUT = "10500";
        String RESOURCE_ACCESS = "10502";
    }

    public interface STATUS {
        String ACTIVATE = "1";
        String DEACTIVATE = "2";
    }

    public interface MA_HANH_DONG {
        String TAO_MOI = "01";
        String CHINH_SUA = "02";
        String XOA = "03";
    }
}
