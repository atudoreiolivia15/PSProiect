package com.spring.controller;

import com.spring.model.Post;
import com.spring.model.User;
import com.spring.repository.UserRepository;
import com.spring.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/create/{userId}")
    public Post createPost(@PathVariable Long userId, @RequestBody Post post) {
        return postService.createPost(post,userId);
    }
    @GetMapping("/getAll")
    @ResponseBody
    public List<Post> retreiveAllPosts(){
        return this.postService.getAllPosts();
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<?> updatePost(@PathVariable Long id, @RequestBody Post post) {
        return this.postService.updatePost(id, post);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deletePost(@PathVariable Long id){
        this.postService.deletePost(id);
        return ResponseEntity.ok("Post deleted successfully");
    }

}
