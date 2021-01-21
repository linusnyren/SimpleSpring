package com.example.demo.bookShelf;

public class BookShelfNotFoundException extends Throwable {
    public BookShelfNotFoundException(long id) {
        super("BookShelf with id " + id + " was not found");
    }
}
