package com.zipcode.group3blog.dto;

public class ImageDTO {
    Long imageId;
    byte[] imageContent;

    public Long getId() {
        return imageId;
    }

    public byte[] getImageContent() {
        return imageContent;
    }

    public void setId(Long id) {
        this.imageId = id;
    }

    public void setImageContent(byte[] imageContent) {
        this.imageContent = imageContent;
    }

}
