package com.example.demo.BookShelf;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookShelfRepository extends JpaRepository<BookShelf, Long> {
    BookShelf findById(long id);
    BookShelf findByAisle(String aisle);
}
