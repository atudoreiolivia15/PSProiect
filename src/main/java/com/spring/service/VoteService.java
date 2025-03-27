package com.spring.service;

import com.spring.model.Post;
import com.spring.model.Tag;
import com.spring.model.User;
import com.spring.model.Vote;
import com.spring.repository.PostRepository;
import com.spring.repository.TagRepository;
import com.spring.repository.UserRepository;
import com.spring.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteService {
    private VoteRepository voteRepository;
    private PostRepository postRepository;
    private UserRepository userRepository;
    @Autowired
    public VoteService(VoteRepository voteRepository, PostRepository postRepository, UserRepository userRepository) {  //Injectăm prin constructor altfel  imi da eroare 401
        this.voteRepository = voteRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public String deleteVote(Long id) {
        try {
            this.voteRepository.deleteById(id);
            return "Deletion Succesfully";
        } catch (Exception e) {
            return "Failed to delete post with id " + id;
        }
    }
    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    public Vote updateTag(Long id, Vote voteDetails) {
        Vote vote = voteRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));

        vote.setVoteType(voteDetails.getVoteType());

        return voteRepository.save(vote);
    }

//    public Vote createPostVote(Long postId, Vote voteDetails) {
//        Optional<Post> postOptional = postRepository.findById(postId);
//        Post post = postOptional.get();
//
//        Long userId = voteDetails.getUser().getId();
//        Optional<User> userOptional = userRepository.findById(userId);
//        User user = userOptional.get();
//
//        voteDetails.setComment(voteDetails.getComment());
//        voteDetails.setPost(post);
//        voteDetails.setUser(user);
//        if (voteDetails.getPost() != null && voteDetails.getComment() != null) {
//            throw new IllegalArgumentException("Vote must be associated with either a post or a comment, not both.");
//        }
//
//        if (voteDetails.getPost() != null) {
//            voteDetails.setComment(null);
//        }

//   }
}
