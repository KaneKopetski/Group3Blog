package com.zipcode.group3blog.group3blog.testServiceLayer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zipcode.group3blog.model.Post;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Entity;

public class PostTest {
    @Test
    public void testClassSignatureAnnotations() {
        Assert.assertTrue(Post.class.isAnnotationPresent(Entity.class));
    }
    @Test
    public void testCreateJson() throws JsonProcessingException {
        ObjectMapper jsonWriter = new ObjectMapper();
        Post post = new Post();
        String json = jsonWriter.writeValueAsString(post);
    }
}
