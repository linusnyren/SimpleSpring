package com.example.demo.bookShelf;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookShelfRepository extends JpaRepository<BookShelf, Long> {
        BookShelf findByAisle(String aisle);

        BookShelf findById(long id);
}
