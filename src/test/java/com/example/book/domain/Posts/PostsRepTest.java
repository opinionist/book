package com.example.book.domain.Posts;

import com.example.book.Repository.PostsRep;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
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

    @Test
    public void BasetimeEntity(){
        LocalDateTime now = LocalDateTime.of(2007,7,28,0,0,0,0);
        postsRep.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        List<Posts> postsList = postsRep.findAll();

        Posts post = postsList.get(0);

        System.out.println(">>>>>>>>> createDate="+post.getCreatedDate()+", modifiedDate="+post.getLastModifiedDate());

        assertThat(post.getCreatedDate()).isAfter(now);
        assertThat(post.getLastModifiedDate()).isAfter(now);
    }
}