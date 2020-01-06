package com.zipcode.group3blog.controller;

import com.zipcode.group3blog.controller.PostController;
import com.zipcode.group3blog.dto.PostDTO;
import com.zipcode.group3blog.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PostController.class)
public class PostControllerTestTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @Mock
//    private PostService postService;
//
//    ResponseEntity<PostDTO> mockPostDTO = new ResponseEntity<>();
//
//    String exampleCourseJson = "{\"name\":\"Spring\",\"description\":\"10 Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";
//
//    @Test
//    public void retrieveDetailsForCourse() throws Exception {
//
//        Mockito.when(
//                postService.readSinglePost(Mockito.anyLong())).thenReturn(mockPostDTO);
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//                "/api/posts").accept(
//                MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        System.out.println(result.getResponse());
//        String expected = "{id:Course1,name:Spring,description:10 Steps}";
//
//        // {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}
//
//        JSONAssert.assertEquals(expected, result.getResponse()
//                .getContentAsString(), false);
//    }
}