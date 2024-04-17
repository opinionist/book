package com.example.book.domain.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class HelloDtoTest {
    @Test
    public void DtoTest() {
        String name = "test";
        int amount = 1000;

        HelloDto dto = new HelloDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}