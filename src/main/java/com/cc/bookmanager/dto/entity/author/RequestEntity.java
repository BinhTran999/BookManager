package com.cc.bookmanager.dto.entity.author;

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

    private Integer gender;
    private String name;
    private String code;
    private Integer serial;
    private Date birthday;

    @Override
    public String toString() {
        return "RequestEntity{" +
                "gender=" + gender +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", serial=" + serial +
                ", birthday=" + birthday +
                '}';
    }
}
