package com.cc.bookmanager.mapper;

import com.cc.bookmanager.dto.entity.author.*;
import com.cc.bookmanager.model.Author;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
@Service
@Component
public interface AuthorMapper extends BaseMapper<RequestEntity, ResponseEntity, Author>{
}
