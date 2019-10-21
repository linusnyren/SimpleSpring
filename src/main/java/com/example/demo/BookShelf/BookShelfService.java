package com.example.demo.BookShelf;

import com.example.demo.Book.Book;
import com.example.demo.Book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BookShelfService {
    @Autowired
    BookShelfRepository bookShelfRepository;
    @Autowired
    BookRepository bookRepository;

    @PostMapping("/addBookShelf")
    public ResponseEntity<BookShelf> addBookshelf(@RequestBody BookShelf bookShelf){
        bookShelfRepository.save(bookShelf);
        return new ResponseEntity<BookShelf>(bookShelf, HttpStatus.ACCEPTED);
    }

    @PostMapping("/bookToShelf")
    public ResponseEntity<BookShelf> addBookToBookShelf(@RequestBody BookShelf bookShelf){
        BookShelf bookShelfdb = bookShelfRepository.findById(bookShelf.getId());
        Book book = bookRepository.findById(bookShelf.getBookList().get(0).getId());

        bookShelfdb.getBookList().add(book);
        bookShelfRepository.save(bookShelfdb);
        return new ResponseEntity<BookShelf>(bookShelfdb, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getBookShelfs")
    public ResponseEntity<List<BookShelf>> getAllBookShelfs(){
        return new ResponseEntity<List<BookShelf>>(bookShelfRepository.findAll(), HttpStatus.ACCEPTED);
    }
}