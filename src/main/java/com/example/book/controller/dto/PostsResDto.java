package com.example.book.controller.dto;

import com.example.book.domain.Posts.Posts;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostsResDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsResDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
