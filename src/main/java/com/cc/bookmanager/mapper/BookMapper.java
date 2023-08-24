package com.cc.bookmanager.mapper;

import com.cc.bookmanager.dto.entity.book.*;
import com.cc.bookmanager.model.Book;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
@Service
@Component
public interface BookMapper extends BaseMapper<RequestEntity, ResponseEntity, Book> {
}
