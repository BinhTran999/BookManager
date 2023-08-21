package com.cc.bookmanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "authors")
@Table(name = "authors", schema = "public")
public class Author extends MDMAEntity {

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "serial")
    private Integer serial;

    @Column(name = "date")
    private Date birthday;

    @Override
    public String toString() {
        return "Author{" +
                "gender=" + gender +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", serial=" + serial +
                ", birthday=" + birthday +
                '}';
    }
}
