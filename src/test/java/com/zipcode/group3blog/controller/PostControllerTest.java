package com.zipcode.group3blog.controller;

import com.zipcode.group3blog.dto.PostDTO;
import com.zipcode.group3blog.service.PostService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PostControllerTest {
    @InjectMocks
    PostController postController;
    @Mock
    private PostService postService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createPostTest() {
        PostDTO postDTO = new PostDTO();
        doNothing().when(postService).createPost(postDTO);
        ResponseEntity responseEntity = postController.createPost(postDTO);
        assertEquals((HttpStatus.CREATED),responseEntity.getStatusCode());

    }

    @Test
    public void createPostExceptionTest(){
        PostDTO postDTO = new PostDTO();
        doThrow(new NullPointerException()).when(postService).createPost(postDTO);
        ResponseEntity responseEntity = postController.createPost(postDTO);
        assertEquals((HttpStatus.INTERNAL_SERVER_ERROR),responseEntity.getStatusCode());

    }

}