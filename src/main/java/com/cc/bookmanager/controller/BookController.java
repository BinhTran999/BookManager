package com.cc.bookmanager.controller;


import com.cc.bookmanager.dto.base.simple.request.ApiListBaseRequest;
import com.cc.bookmanager.dto.entity.book.RequestEntity;
import com.cc.bookmanager.dto.entity.book.ResponseEntity;
import com.cc.bookmanager.dto.entity.book.SearchEntity;
import com.cc.bookmanager.mapper.BookMapper;
import com.cc.bookmanager.model.Book;
import com.cc.bookmanager.repository.BookRepository;
import com.cc.bookmanager.service.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.cc.bookmanager.controller.Endpoints.PREFIX;

@RestController
@RequestMapping(PREFIX + "sach")
@Tag(name = "Danh sách tài khoản", description = "Danh sách chức vụ APIs")
public class BookController extends BaseController<
        Book, RequestEntity, SearchEntity, ApiListBaseRequest, ResponseEntity, UUID, BookMapper, BookRepository, BookService
        > {
    @Autowired
    public BookController(BookService service) {
        super(service);
    }
}

