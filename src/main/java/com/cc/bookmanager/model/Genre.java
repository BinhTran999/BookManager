package com.cc.bookmanager.model;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "genre", schema = "public")
public class Genre extends MDMAEntity {


    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "note")
    private String note;

    @Column(name = "serial")
    private String serial;

    @ManyToMany
    private List<Book> books;

    @ManyToMany
    private List<Author> authors;
}
