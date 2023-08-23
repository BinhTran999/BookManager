package com.cc.bookmanager.service;

import com.cc.bookmanager.dto.base.simple.request.ApiListBaseRequest;
import com.cc.bookmanager.dto.base.simple.response.BasePage;
import com.cc.bookmanager.dto.entity.account.RequestEntity;
import com.cc.bookmanager.dto.entity.account.RequestPasswordEntity;
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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;
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
        response.setPassword(asterisks(request.getPassword()));
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
        BasePage<ResponseEntity> entity = this.map(searchUtil
                .likeOrLikeWithoutSensitiveCase(keyword, "code", "name")
                .findStatus(status)
                .build(searchRequest));
//        List<ResponseEntity> resList = entity.getData();
        for (ResponseEntity res : entity.getData()){
            res.setPassword(asterisks(res.getPassword()));
        }
        return entity;
    }

    private String asterisks(String pass){
        int length = 8;
        StringBuilder asterisks = new StringBuilder();
        for (int i = 0; i < length; i++) {
            asterisks.append("*");
        }
        return asterisks.toString();
    }

    @SneakyThrows
    //@Override
    @Transactional
    public void updatePassword(UUID id, RequestPasswordEntity passwordEntity){
        uniqueValidator.checkIdExist(id);
        if (checkPass(passwordEntity.getOldPass())){
            Account acc = repository.getReferenceById(id);
            acc.setPassword(passwordEntity.getNewPass());
        }
    }

    private Boolean checkPass(String oldPass){
        List<Account> accList = repository.findAll();
        for (Account acc : accList){
            if (Objects.equals(hashPassword(acc.getPassword()), hashPassword(oldPass))){
                return true;
            }
        }
        return false;
    }

    public static String hashPassword(String password) {
        try {
            // Create MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Add password bytes to digest
            md.update(password.getBytes());

            // Get the hash's bytes
            byte[] hashBytes = md.digest();

            // Convert the hash bytes to a hexadecimal representation
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
