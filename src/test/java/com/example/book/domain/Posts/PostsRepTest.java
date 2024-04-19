package com.example.book.domain.Posts;

import com.example.book.Repository.dto.PostsRep;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostsRepTest {

    @Autowired
    PostsRep postsRep;

    @AfterEach
    public void cleanup(){
        postsRep.deleteAll();
    }

    @Test
    public void testAddPost(){
        String title = "Test Title";
        String content = "Test Content";

        postsRep.save(Posts.builder()
                .title(title)
                .content(content)
                .author("minsung0728@gmail.com")
                .build());

        List<Posts> postsList = postsRep.findAll();
        Posts post = postsList.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
    }
}