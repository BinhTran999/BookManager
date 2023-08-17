package com.cc.bookmanager.model;

import com.cc.bookmanager.model.MDMAEntity;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
//No libraries found for 'javax.persistence.Column
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "bookstory")
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

}