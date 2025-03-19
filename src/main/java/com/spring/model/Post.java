package com.spring.model;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name="posts")
public class Post {
    @Id
    @Column(name="post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "post_title")
    private String title;
    @Column(name="post_text")
    private String text;

    @Column(name = "post_created_at")
    private Date date;

    @Column(name="post_image")
    private String imagePath;

    @Column(name="post_status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Post(int id, User user, String title, String text, Date date, String imagePath, Status status) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.text = text;
        this.date = date;
        this.imagePath = imagePath;
        this.status = status;
    }

    public Post() {

    }

    public int getId() {
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

    public Date getDate() {
        return date;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(int id) {
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

    public void setDate(Date date) {
        this.date = date;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
