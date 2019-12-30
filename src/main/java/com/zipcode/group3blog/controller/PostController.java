package com.zipcode.group3blog.controller;

import com.zipcode.group3blog.dto.PostDTO;
import com.zipcode.group3blog.exceptions.PostNotFoundException;
import com.zipcode.group3blog.model.Post;
import com.zipcode.group3blog.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;
    private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);


    @PostMapping
    public ResponseEntity createPost(@RequestBody PostDTO postDTO) {
        String username = postDTO.getUsername();
        String title = postDTO.getTitle();
        String content = postDTO.getContent();
        LOGGER.info("Post creation request received. Username: {}", username);
        LOGGER.info("Post creation request received. Title: {}", title);
        LOGGER.info("Post creation request received. Content: {}", content);
        try {
            postService.createPost(postDTO);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @Valid
    @GetMapping
    public ResponseEntity<List<PostDTO>> showAllPosts() {
        List<PostDTO> allPosts = postService.showAllPosts();
        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

    @GetMapping("/get/{postId}")
    public ResponseEntity<PostDTO> getSinglePost(@PathVariable @RequestBody Long postId) {
        return new ResponseEntity<>(postService.readSinglePost(postId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<Boolean> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.OK);
        }

    @PutMapping
    public ResponseEntity<Post> updatePost(@RequestBody PostDTO postDTO) throws PostNotFoundException {
        postService.updatePost(postDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

