package org.example.jpa;

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
            postService.writePost("title1", "content1");
            postService.writePost("title2", "content2");
            postService.writePost("title3", "content3");
            System.out.println(postService.count());
        };
    }@Bean
    @Order(2)
    public ApplicationRunner baseInitData2ApplicationRunner() {
        return args -> {
            Ut.thread.sleep(1000);
            Post post1 = postService.findById(1).get();
            postService.modify(post1, "title1-1", "content1-1");
        };
    }

}
