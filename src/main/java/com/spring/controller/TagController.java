package com.spring.controller;

import com.spring.model.Tag;
import com.spring.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Tag createTag(@RequestBody Tag tag) {
        return this.tagService.createTag(tag);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public List<Tag> retreiveAllTags(){
        return this.tagService.getAllTags();
    }

    @PutMapping("/update/{id}")
    @ResponseBody
    public Tag updateTag(@PathVariable Long id,@RequestBody Tag tag){
        return this.tagService.updateTag(id,tag);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteTag(@PathVariable Long id){
        this.tagService.deleteTag(id);
        return ResponseEntity.ok("Tag deleted successfully");
    }
}
