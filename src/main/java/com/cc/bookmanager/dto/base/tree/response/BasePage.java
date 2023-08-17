package com.cc.bookmanager.dto.base.tree.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import com.cc.bookmanager.dto.base.tree.response.BaseDto;
import java.util.List;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class BasePage<T extends BaseDto<T>> {
    protected Integer page;
    protected Integer totalPage;
    protected Integer totalRecord;
    protected List<T> data;
}
