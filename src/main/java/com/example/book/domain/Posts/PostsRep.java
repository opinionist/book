package com.example.book.domain.Posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRep extends JpaRepository<Posts, Long> {
}
