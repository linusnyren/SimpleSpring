package com.example.demo.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/addBook/{bookShelfID}")
    public ResponseEntity<Book> addBook(@RequestBody Book book, @PathVariable int bookShelfID) {
        return bookService.addBook(book, bookShelfID);
    }

    @PutMapping("/changeBook")
    public ResponseEntity<Book> alterBook(@RequestBody Book book) {
        return bookService.alterBook(book);
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks() {
        return bookService.getAllBooks();
    }
}
