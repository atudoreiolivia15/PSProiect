package com.spring.controller;

import com.spring.model.Comment;
import com.spring.model.Post;
import com.spring.service.CommentService;
import com.spring.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@RequestBody Comment comment) {
        return this.commentService.createComment(comment);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Comment> retreiveAllComments(){
        return this.commentService.getAllComments();
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Comment updateComment(@PathVariable Long id,@RequestBody Comment comment){
        return this.commentService.updateComment(id,comment);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteComment(@PathVariable Long id){
        this.commentService.deleteComment(id);
        return ResponseEntity.ok("Comment deleted successfully");
    }
}
