package com.zipcode.group3blog.controller;

import com.zipcode.group3blog.dto.CommentDTO;
import com.zipcode.group3blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity createComment(@RequestBody CommentDTO commentDTO){
        commentService.createComment(commentDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Valid
    @GetMapping
    public ResponseEntity<List<CommentDTO>> showAllComments() {
        List<CommentDTO> allComments = commentService.showAllComments();
        return new ResponseEntity<>(allComments, HttpStatus.OK);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<CommentDTO>> showAllCommentsByPost(@PathVariable @RequestBody Long postId) {
        return new ResponseEntity<>(commentService.showAllCommentsByPost(postId), HttpStatus.OK);
    }

    @GetMapping("/{commentId}")
    public ResponseEntity<CommentDTO> getSingleComment(@PathVariable @RequestBody Long commentId) {
        return new ResponseEntity<>(commentService.readSingleComment(commentId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<Boolean> deletePost(@PathVariable @RequestBody Long commentId) {
        commentService.deleteComment(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateComment(@RequestBody CommentDTO commentDTO){
        commentService.updateComment(commentDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

}
