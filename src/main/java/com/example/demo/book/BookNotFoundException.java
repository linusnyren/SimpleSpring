package com.example.demo.book;

public class BookNotFoundException extends Throwable {
    public BookNotFoundException(long id) {
        super("Book with id: " + id + " wasn't found");
    }
}
