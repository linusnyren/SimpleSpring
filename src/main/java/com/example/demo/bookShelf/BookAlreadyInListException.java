package com.example.demo.bookShelf;

import com.example.demo.book.Book;

public class BookAlreadyInListException extends Throwable {
    public BookAlreadyInListException(Book book) {
        super("Book with id : " + book.getId() + " is already in list");
    }
}
