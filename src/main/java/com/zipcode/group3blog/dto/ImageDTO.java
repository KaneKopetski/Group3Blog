package com.zipcode.group3blog.dto;

public class ImageDTO {
    Long id;
    byte[] imageContent;

    public Long getId() {
        return id;
    }

    public byte[] getImageContent() {
        return imageContent;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImageContent(byte[] imageContent) {
        this.imageContent = imageContent;
    }

}
