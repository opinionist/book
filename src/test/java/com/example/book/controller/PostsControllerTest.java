package com.example.book.controller;

import com.example.book.Repository.PostsRep;
import com.example.book.controller.dto.PostsDto;
import com.example.book.controller.dto.PostsUpDto;
import com.example.book.domain.Posts.Posts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostsControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRep postsRep;

    @AfterEach
    public void tearDown(){
        postsRep.deleteAll();
    }

    @Test
    public void postV(){
        String title = "title";
        String content = "content";
        PostsDto requestDto = PostsDto.builder()
                .title(title)
                .content(content)
                .author("author")
                .build();

        String url = "http://localhost:" + port + "/api/vi/posts";

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRep.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }

    @Test
    public void postM() {
        Posts saved = postsRep.save(Posts.builder().
                title("title")
                .content("content")
                .author("author").build());

        Long id = saved.getId();
        String expectTitle = "title2";
        String expectContent = "content2";

        PostsUpDto requestDto = PostsUpDto.builder()
                .id(id)
                .title(expectTitle)
                .content(expectContent)
                .build();

        String url = "http://localhost:" + port + "/api/vi/posts/" + id;

            HttpEntity<PostsUpDto> requestEntity = new HttpEntity<>(requestDto);

            ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRep.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(expectTitle);
        assertThat(all.get(0).getContent()).isEqualTo(expectContent);
    }
}