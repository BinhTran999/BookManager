package com.cc.bookmanager.dto.entity.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.cc.bookmanager.dto.base.simple.request.ApiSearchBaseRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchEntity extends ApiSearchBaseRequest {
    protected Integer status;
    protected String keyword;
}
