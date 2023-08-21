package com.cc.bookmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "books", schema = "public")
public class Book extends MDMAEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "Books_name")
    private String bookName;
    @Column(name = "author")
    private String author;
    @Column(name = "content")
    private String content;
    @Column(name = "serial")
    private Integer serial;
    @ManyToMany
    private List<Genre> genreList;
    @ManyToMany
    private List<Author> authors;

}