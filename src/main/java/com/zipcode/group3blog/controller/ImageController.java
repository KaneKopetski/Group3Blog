package com.zipcode.group3blog.controller;

import com.zipcode.group3blog.dto.ImageDTO;
import com.zipcode.group3blog.model.Image;
import com.zipcode.group3blog.repository.ImageRepository;
import com.zipcode.group3blog.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/image")
public class ImageController {
    @Autowired
   private ImageService imageService;
   @Autowired
    private ImageRepository imageRepository;
   @PostMapping
    public ResponseEntity createImage(@RequestBody ImageDTO imageDTO){
       imageService.createImage(imageDTO);
       return new ResponseEntity(HttpStatus.OK);
   }
   @Valid
@GetMapping
public ResponseEntity<Page<Image>> showAllImages(Pageable pageable){
      Page<Image>allImages = imageRepository.findAllBy(pageable);
      return new ResponseEntity<>(allImages, HttpStatus.OK);
   }
   @GetMapping("/image/(postId")
    public ResponseEntity<List<ImageDTO>> showAllImagesByPost(@PathVariable @RequestBody Long postId){
       return new ResponseEntity<>(imageService.showAllImagesByPost(postId), HttpStatus.OK);
   }
    @GetMapping("/{imageId}")
    public ResponseEntity<ImageDTO> getSingleComment(@PathVariable @RequestBody Long imageId) {
        return new ResponseEntity<>(imageService.readSingleImage(imageId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{imageId}")
    public ResponseEntity<Boolean> deletePost(@PathVariable @RequestBody Long imageId) {
        imageService.deleteImage(imageId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateComment(@RequestBody ImageDTO imageDTO){
        imageService.updateImage(imageDTO);
        return new ResponseEntity(HttpStatus.OK);
    }


}
