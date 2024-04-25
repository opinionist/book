package com.example.book.controller;

import com.example.book.controller.dto.PostsDto;
import com.example.book.controller.dto.PostsResDto;
import com.example.book.controller.dto.PostsUpDto;
import com.example.book.service.PostsSer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostsController {

    private final PostsSer postsService;

    @PostMapping("/api/vi/posts")
    public Long save(@RequestBody PostsDto requestDto){
        return postsService.savePost(requestDto);
    }

    @PostMapping("/api/vi/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpDto requestDto){
        postsService.update(id, requestDto);
        return id;
    }

    @GetMapping("/api/vi/posts/{id}")
    public PostsResDto findByID (@PathVariable Long id){
        return postsService.findById(id);
    }
}
