package com.cc.bookmanager.dto.base.simple.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.cc.bookmanager.enums.TypeSort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiListBaseRequest extends ApiBaseRequest {
    protected String orderBy = "serial";
    protected TypeSort orderDirection = TypeSort.ASC;
    protected Integer size = 10;
    protected Integer page = 0;
}
