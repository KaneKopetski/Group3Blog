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
    ImageService imageService;
    @Autowired
    ImageRepository imageRepository;

//    @PostMapping("/upload")
//    public ResponseEntity createImage(@RequestBody ImageDTO imageDTO){
//        imageService.createImage(imageDTO);
//        return new ResponseEntity(HttpStatus.CREATED);
//    }

    @PostMapping("/upload")
    public ResponseEntity createImage(@RequestParam MultipartFile file) throws IOException {
        Image image = new Image();
        image.setImage(file.getBytes());
        image.setName(file.getName());
        image.setType(file.getContentType());
        imageRepository.save(image);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Image> getSingleImage(@PathVariable @RequestBody Long id) {
        return new ResponseEntity(imageRepository.findById(id), HttpStatus.OK);
    }



}
