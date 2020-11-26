package com.example.demo.Book;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@Entity
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private long id;

    private String author;
    private String title;
    private int releaseYear;

    public Book(String author, String title, int releaseYear) {
        this.author = author;
        this.title = title;
        this.releaseYear=releaseYear;
    }
}
