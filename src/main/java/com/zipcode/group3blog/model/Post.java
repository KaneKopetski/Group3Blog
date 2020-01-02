package com.zipcode.group3blog.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Post {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long postId;
@Column
private String title;
@Lob
@Column
@Type(type = "org.hibernate.type.TextType")
@NotEmpty
private String content;
@Column
private Instant createdOn;
@Column
private Instant updatedOn;
@Column
private String username;
@ManyToMany(cascade = { CascadeType.ALL })
@JoinTable(
        name = "post_tags",
        joinColumns = { @JoinColumn(name = "postId") },
        inverseJoinColumns = { @JoinColumn(name = "tagId") }
)
private List<PostTag> postTags = new ArrayList<>();


    public Long getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Instant getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Instant updatedOn) {
        this.updatedOn = updatedOn;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public List<PostTag> getPostTags() {
        return postTags;
    }

    public void setPostTags(List<PostTag> postTags) {
        this.postTags = postTags;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
