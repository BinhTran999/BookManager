package com.cc.bookmanager.dto.entity.book;

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
    private Date createDate;
    private String bookName;
    private String author;
    private String content;
    private Integer serial;
    private UUID parentId;
}
