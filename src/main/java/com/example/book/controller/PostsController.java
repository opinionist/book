package com.example.book.controller;

import com.example.book.service.PostsSer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostsController {

    private final PostsSer postsService;


}
