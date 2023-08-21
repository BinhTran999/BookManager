package com.cc.bookmanager.service;

import com.cc.bookmanager.dto.base.simple.request.ApiListBaseRequest;
import com.cc.bookmanager.dto.base.simple.response.BasePage;
import com.cc.bookmanager.dto.entity.account.RequestEntity;
import com.cc.bookmanager.dto.entity.account.ResponseEntity;
import com.cc.bookmanager.dto.entity.account.SearchEntity;
import com.cc.bookmanager.exception.ExistedException;
import com.cc.bookmanager.exception.InvalidEmailFormatException;
import com.cc.bookmanager.exception.InvalidPasswordFormatException;
import com.cc.bookmanager.mapper.AccountMapper;
import com.cc.bookmanager.model.Account;
import com.cc.bookmanager.repository.AccountRepository;
import com.cc.bookmanager.validate.PassValidator;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class AccountService extends BaseService<
        Account, RequestEntity, SearchEntity, ApiListBaseRequest, ResponseEntity, UUID, AccountMapper, AccountRepository> {
    public AccountService(@Autowired AccountRepository repository, AccountMapper mapper) {
        super(repository, mapper, "tai khoan");
    }

    protected final String cacheName = "tai khoan";
    public static PassValidator passwordValidator;

    @Override
    @Transactional
    public ResponseEntity create(RequestEntity request) {
        uniqueValidator.checkFieldUniqueOnCreate(request.getCode(), "code");
        if (!passwordValidator.isValidEmail(request.getEmail())){
            throw new InvalidEmailFormatException("Email không đúng định dạng. Vui lòng nhập lại");
        }
        else if (!passwordValidator.isValidPassword(request.getPassword())){
            throw new InvalidPasswordFormatException("Mật khẩu cần có kí tự chữ hoa, chữ thường, chữ số và không có kí tự đặc biệt. Vui lòng nhập lại");
        }
        ResponseEntity response = super.create(request);
        int length = request.getPassword().length();
        StringBuilder asterisks = new StringBuilder();
        for (int i = 0; i < length; i++) {
            asterisks.append("*");
        }
        response.setPassword(asterisks.toString());
        return response;
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
