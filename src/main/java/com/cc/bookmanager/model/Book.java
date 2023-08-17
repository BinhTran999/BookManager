package com.cc.bookmanager.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "books")
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