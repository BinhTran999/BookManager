package com.cc.bookmanager.dto.base.tree.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.With;

@Data
@With
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class ApiBaseRequest {

}

