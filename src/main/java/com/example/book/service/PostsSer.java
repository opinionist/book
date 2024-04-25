package com.example.book.service;

import com.example.book.Repository.PostsRep;
import com.example.book.controller.dto.PostsDto;
import com.example.book.controller.dto.PostsResDto;
import com.example.book.controller.dto.PostsUpDto;
import com.example.book.domain.Posts.Posts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostsSer {
    private final PostsRep postsRep;

    @Transactional
    public Long savePost(PostsDto requestDto) {
        return postsRep.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpDto requestDto) {
        Posts posts = postsRep.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResDto findById(Long id) {
        Posts entity = postsRep.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostsResDto(entity);
    }
}
