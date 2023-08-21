package com.cc.bookmanager.dto.entity.account;

import com.cc.bookmanager.dto.base.simple.response.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEntity extends BaseDto {
    private UUID id;
    private String name;

    private String code;

    private String gender;

    private String password;

    private String email;
    private Date birthday;

    private Integer serial;

    private Integer status;
}
