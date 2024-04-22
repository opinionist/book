package com.example.book.Repository;

import com.example.book.domain.Posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRep extends JpaRepository<Posts, Long> {
}
