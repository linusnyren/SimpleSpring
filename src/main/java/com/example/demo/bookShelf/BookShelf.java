package com.example.demo.bookShelf;

import com.example.demo.book.Book;
import com.example.demo.helperclasses.DatabaseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class BookShelf extends DatabaseModel {

    private String category;
    private String aisle;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Book> bookList;

    public BookShelf(String category, String aisle) {
        this.category = category;
        this.aisle = aisle;
        this.bookList = new ArrayList<>();
    }

    public void addBookToBookShelf(Book book) throws BookAlreadyInListException {
        for (Book b : bookList) {
            if (b.equals(book)) {
                throw new BookAlreadyInListException(book);
                // if this exception aint throwed its unique and can be saved to list below
            }
        }
        bookList.add(book);
    }

    public List<Book> getBookList() {
        return bookList;
    }
//Here is all getters, but im using lombok thankfully
}
