package com.zipcode.group3blog.repository;

        import com.zipcode.group3blog.model.Image;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;
        import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    Image findByPost_PostId(Long postId);

}
