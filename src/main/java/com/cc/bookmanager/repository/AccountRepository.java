package com.cc.bookmanager.repository;

import com.cc.bookmanager.model.Account;
import com.cc.bookmanager.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID>,
        JpaSpecificationExecutor<Account> {
}
