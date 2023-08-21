package com.cc.bookmanager.dto.entity.author;
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
    private String gender;
    private String name;
    private String code;
    private Integer serial;
    private Date birthday;

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", serial=" + serial +
                ", birthday=" + birthday +
                '}';
    }
}
