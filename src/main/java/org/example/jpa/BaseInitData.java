package org.example.jpa;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {

    private final PostService postService;

    @Bean
    @Order(1)
    public ApplicationRunner BaseInitData() {
        return args -> {
            postService.write("title1", "content1");
            postService.write("title2", "content2");
            postService.write("title3", "content3");
            System.out.println(postService.count());
        };
    }

    @Bean
    @Order(2)
    @Transactional
    public ApplicationRunner baseInitData2ApplicationRunner() {
        return args -> {
            Post post4 = postService.write("title3", "content4");
            postService.delete(post4);
        };
    }

}
