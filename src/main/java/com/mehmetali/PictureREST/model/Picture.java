package com.mehmetali.PictureREST.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pictures")
public class Picture {

    public Picture(String title, String description, LocalDateTime created, List<String> tags, byte[] data) {
        this.title = title;
        this.description = description;
        this.created = created;
        this.tags = tags;
        this.data = data;
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
    @Convert(converter = StringListConverter.class)
    @Column(name = "tags", nullable = false)
    private List<String> tags;

    @Column(name = "data")
    private byte[] data;


    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

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
