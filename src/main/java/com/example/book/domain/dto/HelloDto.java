package com.example.book.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloDto {
    private final String name;
    private final int amount;
}
