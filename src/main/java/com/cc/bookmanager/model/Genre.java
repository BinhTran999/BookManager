package com.cc.bookmanager.model;

import jakarta.persistence.ManyToMany;
import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Genre extends MDMAEntity {


    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "note")
    private String note;

    @ManyToMany
    private List<Book> books;
}
