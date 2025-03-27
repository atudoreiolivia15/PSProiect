package com.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;


@Entity
@Table(name="posts")
public class Post {
    @Id
    @Column(name="post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;


    @Column(name = "post_title")
    private String title;
    @Column(name="post_text")
    private String text;

    @Column(name = "post_created_at")
    private LocalDate date;

    @Column(name="post_image")
    private String imagePath;

    @Column(name="post_status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Post(Long id, User user, LocalDate date, String title, String text, String imagePath, Status status) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.title = title;
        this.text = text;
        this.imagePath = imagePath;
        this.status = status;
    }

    public Post() {

    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
