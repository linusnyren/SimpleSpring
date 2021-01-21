package com.example.demo.helperclasses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;

@Entity
public abstract class DatabaseModel implements DataBaseModelInterface {
    @Id
    @GeneratedValue
    private long id;

    private LocalDateTime created;
    private LocalDateTime updated;

    @PrePersist
    private void updateUpdated() {
        this.updated = LocalDateTime.now();
    }

    public DatabaseModel() {
        this.created = LocalDateTime.now();
        this.updated = LocalDateTime.now();
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public long getId() {
        return id;
    }
}
