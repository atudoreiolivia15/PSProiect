package com.spring.controller;

import com.spring.model.Post;
import com.spring.model.Tag;
import com.spring.model.User;
import com.spring.model.Vote;
import com.spring.service.PostService;
import com.spring.service.TagService;
import com.spring.service.UserService;
import com.spring.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/votes")
public class VoteController {
        @Autowired
        private VoteService voteService;
        private UserService userService;
        private PostService postService;

    //    @PostMapping("/create_post_vote/{postId}")
    //    @ResponseStatus(HttpStatus.CREATED)
       // public Vote createVote(@PathVariable Long postId,@RequestBody Vote vote) {
           // return this.voteService.createPostVote(postId, vote);
      //  }

        @GetMapping("/getAll")
        @ResponseBody
        public List<Vote> retreiveAllVotes(){
            return this.voteService.getAllVotes();
        }

        @PutMapping("/update/{id}")
        @ResponseBody
        public Vote updateVote(@PathVariable Long id, @RequestBody Vote vote){
            return this.voteService.updateTag(id,vote);
        }

        @DeleteMapping("/delete/{id}")
        @ResponseBody
        public ResponseEntity<String> deletVote(@PathVariable Long id){
            this.voteService.deleteVote(id);
            return ResponseEntity.ok("Vote deleted successfully");
        }
    }

