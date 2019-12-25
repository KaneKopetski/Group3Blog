package com.zipcode.group3blog.controller;

import com.zipcode.group3blog.dto.PostDTO;
import com.zipcode.group3blog.model.Post;
import com.zipcode.group3blog.repository.PostRepository;
import com.zipcode.group3blog.service.PostService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.mockito.Spy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class PostControllerTest {
    @InjectMocks
    PostController postController;
    @Mock
    private PostService postService;
    @Autowired
    private MockMvc mvc;
    @MockBean
    private PostRepository repository;


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

    @Test
    public void showAllPostsExceptionTest(){
        doThrow(new NullPointerException()).when(postService).showAllPosts();
        ResponseEntity responseEntity = postController.showAllPosts();
        assertEquals((HttpStatus.INTERNAL_SERVER_ERROR),responseEntity.getStatusCode());
    }



}