package com.spring.service;

import com.spring.model.Comment;
import com.spring.model.Post;
import com.spring.model.User;
import com.spring.repository.CommentRepository;
import com.spring.repository.PostRepository;
import com.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    private UserRepository userRepository;
    private PostRepository postRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository) {  //Injectăm prin constructor altfel  imi da eroare 401
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public Comment createComment(Long postId,Long userId, String text, String img) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));

        Comment comment = new Comment();
        comment.setText(text);
        comment.setPost(post);
        comment.setUser(user);
        comment.setDate(LocalDate.now());
        comment.setPath_image(img);

        return this.commentRepository.save(comment);
    }

    public String deleteComment(Long id) {
        try{
            this.commentRepository.deleteById(id);
            return "Deletion Succesfully";
        }catch(Exception e){
            return "Failed to delete post with id " + id;
        }
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment updateComment(Long id, Comment commentDetails) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));

        comment.setText(commentDetails.getText());
        comment.setPath_image(commentDetails.getPath_image());

        return commentRepository.save(comment);
    }


}
