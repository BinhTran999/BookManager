package com.cc.bookmanager.mapper;

import com.cc.bookmanager.dto.entity.genre.*;
import com.cc.bookmanager.model.Genre;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
@Service
@Component
public interface GenreMapper extends BaseMapper<RequestEntity, ResponseEntity, Genre>{
}
