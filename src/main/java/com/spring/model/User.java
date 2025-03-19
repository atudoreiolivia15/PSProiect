package com.spring.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;
    @Column(name = "user_email")
    private String email;
    @Column(name="user_phone")
    private String phone;
    @Column(name = "user_created_at")
    private LocalDate date;
    @Column(name="user_banned")
    private boolean isBanned;
    @Column(name = "user_password")
    private String password;
    @Column(name="user_role")
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany()
    @JoinColumn(name = "posts")
    private List<Post> posts;


    public User(int id, String username, String email, String phone, boolean isBanned, String password, Role role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.isBanned = isBanned;
        this.password = password;
        this.role = role;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setPhone(String phone){this.phone = phone;}
    public String getPhone(){return this.phone;}
    public void setRole(Role role){this.role = role;}
    public Role getRole(){return this.role;}
    public void setDate(LocalDate date){this.date = date;}
    public LocalDate getDate(){return this.date;}
    public void setPosts(Post post){
         posts.add(post);
    }
    public List<Post> getPosts(){
        return posts;
    }

}
