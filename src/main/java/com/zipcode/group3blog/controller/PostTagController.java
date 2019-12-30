package com.zipcode.group3blog.controller;

import com.zipcode.group3blog.dto.PostTagDTO;
import com.zipcode.group3blog.service.PostTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/postTags")
public class PostTagController {
    @Autowired
    PostTagService postTagService;

    @PostMapping("/postTag")
    public ResponseEntity createPostTag(@RequestBody PostTagDTO posTagDTO){
        postTagService.createPostTag(posTagDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @GetMapping("/postTag")
    public ResponseEntity<List<PostTagDTO>> showPostTags(){
        List<PostTagDTO> allPostTag =postTagService.showAllPostTags();
        return new ResponseEntity<>(allPostTag,HttpStatus.OK);
    }
    @DeleteMapping("/postTag/{postTagId}")
    public ResponseEntity<Boolean> deletePostTagById(@PathVariable @RequestBody Long postTagId){
        postTagService.deletePostTag(postTagId);
        return  new ResponseEntity<>(HttpStatus.OK);
    }


}
