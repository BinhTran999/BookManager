package com.cc.bookmanager.dto.base.tree.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public abstract class BaseDto<T extends  BaseDto<T>>  {
    private Date createDate;
    private String createdUser;
    private Date lastUpdateDate;
    private String lastUpdateBy;


}
