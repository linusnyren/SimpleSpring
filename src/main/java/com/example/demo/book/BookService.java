package com.example.demo.book;


import com.example.demo.bookShelf.BookAlreadyInListException;
import com.example.demo.bookShelf.BookShelf;
import com.example.demo.bookShelf.BookShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookShelfRepository bookShelfRepository;

    public ResponseEntity<Book> addBook(@RequestBody Book book, @PathVariable int bookShelfID) {
        bookRepository.save(book);
        BookShelf bookShelf = bookShelfRepository.findById(bookShelfID);
        try {
            bookShelf.addBookToBookShelf(book);
            bookShelfRepository.save(bookShelf);
            return new ResponseEntity<>(book, HttpStatus.ACCEPTED);
        } catch (BookAlreadyInListException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    public ResponseEntity<Book> alterBook(@RequestBody Book book) {
        Book bookDb = bookRepository.findById(book.getId());
        if (bookDb != null) {
            bookDb = book;
            bookRepository.save(bookDb);
            return new ResponseEntity<>(bookDb, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<Book>(HttpStatus.BAD_REQUEST);
        }

    }
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.ACCEPTED);
    }
}
