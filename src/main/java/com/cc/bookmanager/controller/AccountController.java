package com.cc.bookmanager.controller;

import com.cc.bookmanager.dto.base.simple.request.ApiListBaseRequest;
import com.cc.bookmanager.dto.base.simple.response.ApiBaseObjectResponse;
import com.cc.bookmanager.dto.base.simple.response.ApiBaseResponse;
import com.cc.bookmanager.dto.entity.account.RequestEntity;
import com.cc.bookmanager.dto.entity.account.RequestPasswordEntity;
import com.cc.bookmanager.dto.entity.account.ResponseEntity;
import com.cc.bookmanager.dto.entity.account.SearchEntity;
import com.cc.bookmanager.mapper.AccountMapper;
import com.cc.bookmanager.model.Account;
import com.cc.bookmanager.repository.AccountRepository;
import com.cc.bookmanager.service.AccountService;
import com.cc.bookmanager.service.AuthorService;
import com.cc.bookmanager.validate.ValidUUID;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.cc.bookmanager.controller.Endpoints.PREFIX;
import static com.cc.bookmanager.controller.Endpoints.UPDATE_PATH;

@RestController
@RequestMapping(PREFIX + "tai-khoan")
@Tag(name = "Danh mục tài khoản", description = "Danh mục tài khoản APIs")
public class AccountController extends BaseController<
        Account, RequestEntity, SearchEntity, ApiListBaseRequest, ResponseEntity, UUID, AccountMapper, AccountRepository, AccountService> {

    @Autowired
    public AccountController(AccountService service) {
        super(service);
    }

    @RequestMapping(value = UPDATE_PATH, method = RequestMethod.PUT)
    public ApiBaseResponse updatePassword(@PathVariable @ValidUUID UUID uuid, @RequestBody RequestPasswordEntity reqUpdate) {
        service.updatePassword(uuid, reqUpdate);
        return apiResponseBuilder.success();
    }

}
