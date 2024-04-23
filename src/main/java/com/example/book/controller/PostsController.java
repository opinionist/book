package com.example.book.controller;

import com.example.book.controller.dto.PostsDto;
import com.example.book.controller.dto.PostsResDto;
import com.example.book.service.PostsSer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostsController {

    private final PostsSer postsService;

    @PutMapping("/api/vi/posts")
    public Long save(@RequestBody PostsDto requestDto){
        return postsService.savePost(requestDto);
    }

    @PutMapping("/api/vi/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsResDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/vi/posts/{id}")
    public PostsResDto findByID (@PathVariable Long id){
        return postsService.findById(id);
    }
}
