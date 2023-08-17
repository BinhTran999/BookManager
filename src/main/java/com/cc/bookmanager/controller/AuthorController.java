package com.cc.bookmanager.controller;

import com.cc.bookmanager.dto.base.simple.request.ApiListBaseRequest;
import com.cc.bookmanager.dto.entity.author.*;
import com.cc.bookmanager.mapper.AuthorMapper;
import com.cc.bookmanager.model.Author;
import com.cc.bookmanager.repository.AuthorRepository;
import com.cc.bookmanager.service.AuthorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.cc.bookmanager.controller.Endpoints.PREFIX;

@RestController
@RequestMapping(PREFIX + "tac-gia")
@Tag(name = "Danh mục chức vụ", description = "Danh mục chức vụ APIs")
public class AuthorController extends BaseController<
        Author, RequestEntity, SearchEntity, ApiListBaseRequest, ResponseEntity, UUID, AuthorMapper, AuthorRepository, AuthorService
        > {
    @Autowired
    public AuthorController(AuthorService service) {
        super(service);
    }
}
