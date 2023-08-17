package com.cc.bookmanager.dto.base.tree.request;

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
    //protected String orderBy = "order";
    protected TypeSort orderDirection = TypeSort.ASC;
    protected Integer size = 20;
    protected Integer page = 0;
}
