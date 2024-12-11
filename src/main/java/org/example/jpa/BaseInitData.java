package org.example.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {

    private final PostService postService;

    @Bean
    public ApplicationRunner BaseInitData() {
        return args -> {
            postService.writePost("title1", "content1");
            postService.writePost("title2", "content2");
            postService.writePost("title3", "content3");
            System.out.println(postService.count());
        };
    }

}
