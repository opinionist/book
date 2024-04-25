package com.example.book.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpDto {
    private Long id;
    private String title;
    private String content;

    @Builder
    public PostsUpDto(Long id,String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
