package com.example.demo.bookShelf;

import com.example.demo.book.Book;
import com.example.demo.book.BookNotFoundException;
import com.example.demo.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookShelfService {
    @Autowired
    BookShelfRepository bookShelfRepository;
    @Autowired
    BookRepository bookRepository;

    public ResponseEntity<BookShelf> addBookshelf(@RequestBody BookShelf bookShelf) {
        bookShelfRepository.save(bookShelf);
        return new ResponseEntity<BookShelf>(bookShelf, HttpStatus.ACCEPTED);
    }

    public ResponseEntity<BookShelf> addBookToBookShelf(@RequestBody BookShelf bookShelf) throws BookShelfNotFoundException, BookNotFoundException {

        BookShelf bookShelfdb = bookShelfRepository.findById(bookShelf.getId());
        if (bookShelfdb == null)
            throw new BookShelfNotFoundException(bookShelf.getId());

        Book book = bookRepository.findById(bookShelf.getBookList().get(0).getId());
        if (book == null)
            throw new BookNotFoundException(book.getId());

        try {

            bookShelfdb.addBookToBookShelf(book);
            bookShelfRepository.save(bookShelfdb);
            return new ResponseEntity<BookShelf>(bookShelfdb, HttpStatus.ACCEPTED);
        } catch (BookAlreadyInListException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<List<BookShelf>> getAllBookShelfs(){
        return new ResponseEntity<List<BookShelf>>(bookShelfRepository.findAll(), HttpStatus.ACCEPTED);
    }
}
