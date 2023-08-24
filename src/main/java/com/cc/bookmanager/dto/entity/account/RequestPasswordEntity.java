package com.cc.bookmanager.dto.entity.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestPasswordEntity {

    private String oldPass;

    private String newPass;
}
