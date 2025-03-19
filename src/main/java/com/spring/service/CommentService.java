package com.spring.service;

import com.spring.model.Comment;
import com.spring.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private CommentRepository commentRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository) {  //Injectăm prin constructor altfel  imi da eroare 401
        this.commentRepository = commentRepository;
    }

    public Comment createComment(Comment comment) {
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
