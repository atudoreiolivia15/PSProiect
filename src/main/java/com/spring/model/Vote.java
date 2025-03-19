package com.spring.model;

import jakarta.persistence.*;

@Entity
public class Vote {
    @Id
    private int id;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne()//????
    @JoinColumn(name="post_id")
    private Post post;

    @Column(name = "vote_type")
    private VoteType voteType;

    public Vote(int id, User user, Post post, VoteType voteType) {
        this.id = id;
        this.user = user;
        this.post = post;
        this.voteType = voteType;
    }

    public Vote() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public VoteType getVoteType() {
        return voteType;
    }

    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }
}
