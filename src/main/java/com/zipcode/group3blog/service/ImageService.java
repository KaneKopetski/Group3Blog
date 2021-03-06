package com.zipcode.group3blog.service;

import com.zipcode.group3blog.dto.ImageDTO;
import com.zipcode.group3blog.exceptions.ImageNotFoundException;
import com.zipcode.group3blog.model.Image;
import com.zipcode.group3blog.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ImageService {
    @Autowired
    private AuthService authService;
    @Autowired
    private ImageRepository imageRepository;

    @Transactional
    public List<ImageDTO> showAllImages(){
        List<Image> images = imageRepository.findAll();
        return images.stream().map(this::mapFromImageToDTO).collect(toList());
    }

    @Transactional
    public void createImage(ImageDTO imageDTO){
        Image image = mapFromDTOToImage(imageDTO);
        imageRepository.save(image);
    }

    @Transactional
    public ImageDTO readSingleImage(Long id) {
        Image image = imageRepository.findById(id).orElseThrow(() ->
                new ImageNotFoundException("For id " + id));
        return mapFromImageToDTO(image);
    }

    @Transactional
    public void deleteImage(Long id) {
        ImageDTO imageToDelete = readSingleImage(id);
        Image image = mapFromDTOToImage(imageToDelete);
        imageRepository.delete(image);
    }

    private ImageDTO mapFromImageToDTO(Image image) {
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setId(image.getImageId());
        imageDTO.setImageContent(image.getImage());
        return imageDTO;
    }

    private Image mapFromDTOToImage(ImageDTO imageDTO) {
        Image image = new Image();
        image.setImage(imageDTO.getImageContent());
        User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("Users Not Found"));
        image.setCreatedOn(Instant.now());
        image.setUsername(loggedInUser.getUsername());
        return image;
    }

}
