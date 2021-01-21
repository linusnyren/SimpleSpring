package com.example.demo.book;

import com.example.demo.helperclasses.DatabaseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@Data
@Entity
@NoArgsConstructor
public class Book extends DatabaseModel {

    private String author;
    private String title;
    private int releaseYear;

    public Book(String author, String title, int releaseYear) {
        this.author = author;
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public boolean equals(Book b) {
        return author.equals(b.author)
                && title.equals(title)
                && releaseYear == b.releaseYear;
    }
}
