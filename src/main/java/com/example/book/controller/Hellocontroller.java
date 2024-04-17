package com.example.book.controller;

import com.example.book.domain.dto.HelloDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hellocontroller {
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/hello/dto")
    public HelloDto dto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloDto(name, amount);
    }
}
