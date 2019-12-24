package com.zipcode.group3blog.controller;

import com.zipcode.group3blog.model.Image;
import com.zipcode.group3blog.repository.ImageRepository;
import com.zipcode.group3blog.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/images")
public class ImageController {

    @Autowired
//    ImageService imageService;
    @Autowired
    ImageRepository imageRepository;

    @PostMapping("/upload")
    public Image uploadImage(@RequestParam("myFile") MultipartFile file) throws IOException {
        Image img = new Image( file.getOriginalFilename(), file.getContentType(), file.getBytes());
        final Image savedImage = imageRepository.save(img);
        return savedImage;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Image> getSingleImage(@PathVariable @RequestBody Long id) {
        return new ResponseEntity(imageRepository.findById(id), HttpStatus.OK);
    }



}
