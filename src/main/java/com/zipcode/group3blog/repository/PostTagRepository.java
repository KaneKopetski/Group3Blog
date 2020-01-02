package com.zipcode.group3blog.repository;

import com.zipcode.group3blog.model.Post;
import com.zipcode.group3blog.model.PostTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostTagRepository extends JpaRepository<PostTag, Long> {
//    List<Post> findByPost_PostId(Long postId);

}
