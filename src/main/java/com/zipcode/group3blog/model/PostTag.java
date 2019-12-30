package com.zipcode.group3blog.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class PostTag {
    @Id
    @GeneratedValue
    private Long tagId;
    @Column
    @NotBlank
    private String tagName;
//    @ManyToMany(mappedBy = "post_tags")
//    private Set<Post> posts = new HashSet<>();
    @ManyToOne
    private Post post;

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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
