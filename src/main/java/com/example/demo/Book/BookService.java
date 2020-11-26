package com.example.demo.Book;


import com.example.demo.BookShelf.BookShelf;
import com.example.demo.BookShelf.BookShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookShelfRepository bookShelfRepository;

    @PostMapping("/addBook/{bookShelfID}")
    public ResponseEntity<Book> addBook(@RequestBody Book book, @PathVariable int bookShelfID){
        bookRepository.save(book);
        BookShelf bookShelf = bookShelfRepository.findById(bookShelfID);
        bookShelf.getBookList().add(book);
        bookShelfRepository.save(bookShelf);

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
