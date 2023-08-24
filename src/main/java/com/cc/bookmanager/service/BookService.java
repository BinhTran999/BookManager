package com.cc.bookmanager.service;

import com.cc.bookmanager.dto.base.simple.request.ApiListBaseRequest;
import com.cc.bookmanager.dto.base.simple.response.BasePage;
import com.cc.bookmanager.dto.entity.book.*;
import com.cc.bookmanager.mapper.BookMapper;
import com.cc.bookmanager.model.Book;
import com.cc.bookmanager.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class BookService extends BaseService<
        Book, RequestEntity, SearchEntity, ApiListBaseRequest, ResponseEntity, UUID, BookMapper, BookRepository> {


    public BookService(@Autowired BookRepository repository, BookMapper mapper) {
        super(repository, mapper, "tac gia");
    }

    @Override
    @Transactional
    public ResponseEntity create(RequestEntity request) {
        uniqueValidator.checkFieldUniqueOnCreate(request.getCode(), "code");
        return super.create(request);
    }

    @SneakyThrows
    @Override
    @Transactional
    public ResponseEntity update(UUID id, RequestEntity req) {
        uniqueValidator.checkIdExist(id);
        uniqueValidator.checkFieldUniqueOnUpdate(id, req.getCode(), "code");
        return super.update(id, req);
    }

    @Override
    @Transactional
    public BasePage<ResponseEntity> search(SearchEntity searchRequest) {
        String keyword = searchRequest.getKeyword();
        Integer status = searchRequest.getStatus();
        return this.map(searchUtil
                .likeOrLikeWithoutSensitiveCase(keyword, "code", "name")
                .findStatus(status)
                .build(searchRequest));
    }
}