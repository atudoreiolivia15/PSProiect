package com.spring.controller;

import com.spring.model.Post;
import com.spring.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post) {
        return this.postService.createPost(post);
    }
    //????? nu imi returneaza lista de postari
    @GetMapping("/getAll")
    @ResponseBody
    public List<Post> retreiveAllPosts(){
        return this.postService.getAllPosts();
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Post updatePost(@PathVariable Long id,@RequestBody Post post){
        return this.postService.updatePost(id,post);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deletePost(@PathVariable Long id){
        this.postService.deletePost(id);
        return ResponseEntity.ok("Post deleted successfully");
    }


}
