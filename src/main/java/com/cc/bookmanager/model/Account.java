package com.cc.bookmanager.model;

import lombok.*;
//No libraries found for 'javax.persistence.Column
import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "public")
public class Account extends MDMAEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
    @Column(name = "gender")
    private Integer gender;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "serial")
    private Integer serial;
    @Column(name = "status")
    private Integer status;

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", gender=" + gender +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", serial=" + serial +
                ", status=" + status +
                '}';
    }
}