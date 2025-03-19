package com.spring.service;

import com.spring.dto.PostRequest;
import com.spring.model.Post;
import com.spring.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;
    @Autowired
    public PostService(PostRepository postRepository) {  //Injectăm prin constructor altfel  imi da eroare 401
        this.postRepository = postRepository;
    }

    public Post createPost(Post post) {
        return this.postRepository.save(post);
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

    public Post updatePost(Long id,Post postDetails) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));

        post.setTitle(postDetails.getTitle());
        post.setText(postDetails.getText());
        post.setStatus(postDetails.getStatus());
        post.setImagePath(postDetails.getImagePath());

        return postRepository.save(post);
    }
}
