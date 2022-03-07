package com.example.eventcooker.masterdata.repositories.posts;

import com.example.eventcooker.masterdata.models.posts.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUser(Long user);
    List<Post> findByEmployee(Long employee);
}
