package com.cc.bookmanager.controller;

import com.cc.bookmanager.dto.base.simple.request.ApiListBaseRequest;
import com.cc.bookmanager.dto.entity.genre.*;
import com.cc.bookmanager.mapper.GenreMapper;
import com.cc.bookmanager.model.Genre;
import com.cc.bookmanager.repository.GenreRepository;
import com.cc.bookmanager.service.GenreService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static com.cc.bookmanager.controller.Endpoints.PREFIX;

@RestController
@RequestMapping(PREFIX + "the-loai")
@Tag(name = "Danh sách tài khoản", description = "Danh sách chức vụ APIs")
public class GenreController extends BaseController<
        Genre, RequestEntity, SearchEntity, ApiListBaseRequest, ResponseEntity, UUID, GenreMapper, GenreRepository, GenreService
        > {
    @Autowired
    public GenreController(GenreService service) {
        super(service);
    }
}
