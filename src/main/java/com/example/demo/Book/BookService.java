package com.example.demo.Book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @RequestMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        bookRepository.save(book);
        return new ResponseEntity<Book>(book, HttpStatus.ACCEPTED);
    }
    @PutMapping("/changeBook")
    public ResponseEntity<Book> alterBook(@RequestBody Book book){
        Book bookDb = bookRepository.findById(book.getId());
        bookDb = book;
        bookRepository.save(bookDb);
        return new ResponseEntity<Book>(bookDb, HttpStatus.ACCEPTED);
    }
    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<List<Book>>(bookRepository.findAll(), HttpStatus.ACCEPTED);
    }
}
