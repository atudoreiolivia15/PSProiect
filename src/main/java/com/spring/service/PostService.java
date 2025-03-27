package com.spring.service;

import com.spring.dto.PostRequest;
import com.spring.model.Post;
import com.spring.model.User;
import com.spring.repository.PostRepository;
import com.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;
    private UserRepository userRepository;
    @Autowired
    public PostService(PostRepository postRepository,UserRepository userRepository) {  //Injectez prin constructor altfel  imi da eroare
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public Post createPost(Post post, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.get();
        post.setUser(user);
        user.setPosts(post);
        user.setDate(LocalDate.now());

        return postRepository.save(post);

    }

    public String deletePost(Long id) {
        try{
            this.postRepository.deleteById(id);
            return "Deletion Succesfully";
        }catch(Exception e){
            return "Failed to delete post with id " + id;
        }
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
    //TODO
    public ResponseEntity<?> updatePost(Long id, Post postDetails) {
        Post post = postRepository.findById(id).orElse(null);

        if (post == null) {
            return ResponseEntity.ok("The Post with ID " + id + " doesn't exist. Failed update");
        }

        post.setTitle(postDetails.getTitle());
        post.setText(postDetails.getText());
        post.setStatus(postDetails.getStatus());
        post.setImagePath(postDetails.getImagePath());
        post.setDate(LocalDate.now());
        Post updatedPost = postRepository.save(post);

        return ResponseEntity.ok(updatedPost);
    }

}
