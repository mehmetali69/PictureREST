package com.mehmetali.PictureREST.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pictures")
public class Picture {

    public Picture(String title, String description, LocalDateTime created) {

        this.title = title;
        this.description = description;
        this.created = created;
    }

    public Picture() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "created")
    private LocalDateTime created;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
