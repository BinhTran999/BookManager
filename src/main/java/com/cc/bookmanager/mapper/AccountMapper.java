package com.cc.bookmanager.mapper;

import com.cc.bookmanager.dto.entity.account.RequestEntity;
import com.cc.bookmanager.dto.entity.account.ResponseEntity;
import com.cc.bookmanager.model.Account;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
@Service
@Component
public interface AccountMapper extends BaseMapper<RequestEntity, ResponseEntity, Account> {
}
