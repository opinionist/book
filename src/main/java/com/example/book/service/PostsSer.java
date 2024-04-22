package com.example.book.service;

import com.example.book.Repository.PostsRep;
import com.example.book.controller.dto.PostsDto;
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
}
