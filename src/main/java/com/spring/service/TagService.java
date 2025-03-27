package com.spring.service;

import com.spring.model.Comment;
import com.spring.model.Post;
import com.spring.model.Tag;
import com.spring.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private TagRepository tagRepository;
    @Autowired
    public TagService(TagRepository tagRepository) {  //Injectăm prin constructor altfel  imi da eroare 401
        this.tagRepository = tagRepository;
    }

    public Tag createTag(Tag tag) {
        return this.tagRepository.save(tag);
    }

    public String deleteTag(Long id) {
        try {
            this.tagRepository.deleteById(id);
            return "Deletion Succesfully";
        } catch (Exception e) {
            return "Failed to delete post with id " + id;
        }
    }
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Tag updateTag(Long id,Tag postDetails) {
        Tag tag = tagRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));

        tag.setName(postDetails.getName());

        return tagRepository.save(tag);
    }

}


