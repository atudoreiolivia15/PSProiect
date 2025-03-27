package com.spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Votes")
public class Vote {
    @Id
    @Column(name="vote_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false) // nu permite existenta voturilor fara un user
    private User user;
    @ManyToOne
    @JoinColumn(name="comment_id", nullable = true)// daca se doreste votarea unui comment atunci post se considera = null iar comment != null
    private Comment comment;// altfel comment este null si se deduce ca postarea va fi votata

    @ManyToOne()
    @JoinColumn(name="post_id")
    private Post post;

    @Column(name = "vote_type")
    private VoteType voteType;


    public Vote(User user, Post post, Comment comment, VoteType voteType) {
        this.user = user;
        this.post = post;
        this.comment = comment;
        this.voteType = voteType;

        //validare pentru a preveni cazurile in care ambele sunt null sau ambele sunt setate
        if ((post == null && comment == null) || (post != null && comment != null)) {
            throw new IllegalArgumentException("Vote must be associated with either a post or a comment, not both.");
        }
    }

    public Vote() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
    public VoteType getVoteType() {
        return voteType;
    }

    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }
}
