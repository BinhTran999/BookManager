package com.cc.bookmanager.dto.entity.account;

import com.cc.bookmanager.dto.base.simple.request.ApiBaseRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestEntity extends ApiBaseRequest {

    private String name;

    private String code;

    private String sex;

    private String password;

    private String email;


    private Integer serial;

    private Integer status;
}
