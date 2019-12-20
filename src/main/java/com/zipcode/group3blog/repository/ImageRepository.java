package com.zipcode.group3blog.repository;


import com.zipcode.group3blog.model.Comment;
import com.zipcode.group3blog.model.Image;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByPost_PostId(Long postId);
    Page<Image> findAllBy(Pageable pageable);

}
