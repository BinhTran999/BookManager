package com.cc.bookmanager.dto.base.simple.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasePage<T extends BaseDto> {
    protected Integer page;
    protected Integer totalPage;
    protected Long totalRecord;
    protected List<T> data;
}
