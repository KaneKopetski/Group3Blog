package com.zipcode.group3blog.service;

import com.zipcode.group3blog.dto.PostTagDTO;
import com.zipcode.group3blog.model.PostTag;
import com.zipcode.group3blog.repository.PostTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class PostTagService {
    @Autowired
    PostTagRepository postTagRepository;

    public List<PostTagDTO> showAllPostTags() {
        List<PostTag> tags = postTagRepository.findAll();
        return tags.stream().map(this::mapFromPostTagToPostDTO).collect(toList());
    }
    private PostTagDTO mapFromPostTagToPostDTO(PostTag tag){
        PostTagDTO postTagDTO = new PostTagDTO();
        postTagDTO.setId(tag.getTagId());
        postTagDTO.setTagName(tag.getTagName());
        return postTagDTO;
    }

    public void createPostTag(PostTagDTO postTagDto) {
        PostTag postTag = mapFromDTOToPostTag(postTagDto);
        postTagRepository.save(postTag);
    }
    private PostTag mapFromDTOToPostTag(PostTagDTO postTagDTO){
       PostTag postTag = new PostTag();
       postTag.setTagId(postTagDTO.getId());
       postTag.setTagName(postTagDTO.getTagName());
       return postTag;
    }
    public void deletePostTag(Long id) {
        postTagRepository.deleteById(id);
    }



}
