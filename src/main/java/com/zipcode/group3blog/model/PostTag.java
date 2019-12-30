package com.zipcode.group3blog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
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

            @Override
    public String toString() {
        return "PostTags{" +
                "tagId=" + tagId +
                ", tagName=" + tagName +
                '}';
    }
}
