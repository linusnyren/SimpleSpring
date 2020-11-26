package com.example.demo.BookShelf;

import com.example.demo.Book.Book;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class BookShelf {
    @Id
    @GeneratedValue
    private long id;
    private String category;
    private String aisle;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Book> bookList;

    public BookShelf(String category, String aisle) {
        this.category = category;
        this.aisle = aisle;
        this.bookList = new ArrayList<>();
    }
//Here is all getters, but im using lombok thankfully
}
