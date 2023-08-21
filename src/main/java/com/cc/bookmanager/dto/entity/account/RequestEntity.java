package com.cc.bookmanager.dto.entity.account;

import com.cc.bookmanager.dto.base.simple.request.ApiBaseRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestEntity extends ApiBaseRequest {

    private String name;

    private String code;

    private String gender;

    private String password;

    private String email;

    private Date birthday;


    private Integer serial;

    private Integer status;
}
