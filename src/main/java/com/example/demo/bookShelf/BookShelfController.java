package com.example.demo.bookShelf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BookShelfController {

    @Autowired
    BookShelfService bookShelfService;

    @PostMapping("/addBookShelf")
    public ResponseEntity<BookShelf> addBookshelf(@RequestBody BookShelf bookShelf){
        return bookShelfService.addBookshelf(bookShelf);
    }
    @PostMapping("/bookToShelf")
    public ResponseEntity<BookShelf> addBookToBookShelf(@RequestBody BookShelf bookShelf){
        return bookShelfService.addBookshelf(bookShelf);
    }
    @GetMapping("/getBookShelfs")
    public ResponseEntity<List<BookShelf>> getAllBookShelfs(){
        return bookShelfService.getAllBookShelfs();
    }
}
