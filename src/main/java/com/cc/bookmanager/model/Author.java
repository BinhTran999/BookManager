package com.cc.bookmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Data
@Entity
@Table(name = "authors", schema = "bookstory")
public class Author extends MDMAEntity {

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "serial")
    private Integer serial;
}
