package com.cc.bookmanager.dto.entity.author;

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

    private String sex;
    private String name;
    private String code;
    private String nation;
    private Integer serial;
}
