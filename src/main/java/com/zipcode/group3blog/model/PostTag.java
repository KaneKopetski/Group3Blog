package com.zipcode.group3blog.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PostTag {
    @Id
    @GeneratedValue
    private Long tagId;
    @Column
    @NotBlank
    private String tagName;
    @ManyToMany(mappedBy = "postTags")
    private Set<Post> posts = new HashSet<>();

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
