package com.zipcode.group3blog.repository;

import com.zipcode.group3blog.model.PostTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostTagRepository extends JpaRepository<PostTag,Long> {

}
