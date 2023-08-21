package com.cc.bookmanager.dto.entity.book;

import com.cc.bookmanager.dto.base.simple.response.BaseDto;
import com.cc.bookmanager.model.Author;
import com.cc.bookmanager.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEntity extends BaseDto {

    private UUID id;
    private Date createDate;
    private String bookName;
    private List<Author> authors;
    private List<Genre> genreList;
    private String content;
    private Integer serial;
    private UUID parentId;
}
