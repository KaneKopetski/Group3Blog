package com.zipcode.group3blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class PostTags {
    @Id
    @GeneratedValue
    private Long tagId;
    @NotBlank
    @OneToMany
    private Long tagName;

    private List<PostTags> tagList;

    public Long getTagId() {
        return tagId;
    }

    public Long getTagName() {
        return tagName;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public void setTagName(Long tagName) {
        this.tagName = tagName;
    }

    @Override
    public String toString() {
        return "PostTags{" +
                "tagId=" + tagId +
                ", tagName=" + tagName +
                '}';
    }
}
