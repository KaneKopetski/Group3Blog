package com.zipcode.group3blog.controller;

import com.zipcode.group3blog.dto.PostTagDTO;
import com.zipcode.group3blog.service.PostTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class PostTagController {

    @Autowired
    private PostTagService postTagService;

    @PostMapping
    public ResponseEntity createPostTag(@RequestBody PostTagDTO postTagDTO){
        postTagService.createPostTag(postTagDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostTagDTO>> showPostTags(){
        List<PostTagDTO> allPostTag = postTagService.showAllPostTags();
        return new ResponseEntity<>(allPostTag,HttpStatus.OK);
    }

    @DeleteMapping("/{postTagId}")
    public ResponseEntity<Boolean> deletePostTagById(@PathVariable Long postTagId){
        postTagService.deletePostTag(postTagId);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


}
