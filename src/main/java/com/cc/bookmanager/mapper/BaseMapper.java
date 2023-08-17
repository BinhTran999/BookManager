package com.cc.bookmanager.mapper;

import com.cc.bookmanager.dto.base.simple.request.ApiBaseRequest;
import com.cc.bookmanager.dto.base.simple.response.BaseDto;
import com.cc.bookmanager.model.MDMAEntity;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface BaseMapper<REQ_ENTITY extends ApiBaseRequest, RES_ENTITY extends BaseDto, ENTITY extends MDMAEntity>  {
    ENTITY toEntity(REQ_ENTITY dto);

    RES_ENTITY toDao(ENTITY entity);

    List<RES_ENTITY> toListDao(List<ENTITY> entity);

    void update(REQ_ENTITY req, @MappingTarget ENTITY entity);

}
