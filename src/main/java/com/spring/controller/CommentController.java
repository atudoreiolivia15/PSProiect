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
import java.util.Map;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/create/{postId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment createComment(@PathVariable Long postId, @RequestBody Map<String, Object> requestBody) {
        Long userId = ((Number) requestBody.get("userId")).longValue();
        String commentText = (String) requestBody.get("text");
        String img = (String) requestBody.get("img");

        return this.commentService.createComment(postId,userId,commentText, img);
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
