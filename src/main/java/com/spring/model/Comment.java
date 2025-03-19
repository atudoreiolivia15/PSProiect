package com.spring.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Comment {
    @Id
    private int id;

    @ManyToOne()
    @JoinColumn(name="post_id")
    private Post post;

    @Column(name = "text")
    private String text;
    @Column(name="image")
    private String path_image;
    @Column(name="created_at")
    private LocalDate date;
    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;

    public Comment(int id, Post post, String text, String path_image, LocalDate date, User user) {
        this.id = id;
        this.post = post;
        this.text = text;
        this.path_image = path_image;
        this.date = date;
        this.user = user;
    }

    public Comment() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPath_image(String path_image) {
        this.path_image = path_image;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public Post getPost() {
        return post;
    }

    public String getText() {
        return text;
    }

    public String getPath_image() {
        return path_image;
    }

    public LocalDate getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }
}
