package org.example.jpa;

import lombok.RequiredArgsConstructor;
import org.example.jpa.post.comment.PostComment;
import org.example.jpa.post.comment.PostCommentService;
import org.example.jpa.post.post.Post;
import org.example.jpa.post.post.PostService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {
    private final PostService postService;
    private final PostCommentService postCommentService;

    @Bean
    public ApplicationRunner baseInitData1ApplicationRunner() {
        return args -> {
            if (postService.count() > 0) return;
            Post post1 = postService.write("title1", "content1");
            Post post2 = postService.write("title2", "content2");
            Post post3 = postService.write("title3", "content3");
            // 1번글에 대한 댓글 1 생성
            PostComment postComment1 = postCommentService.write(post1, "comment1");
            // 1번글에 대한 댓글 2 생성
            PostComment postComment2 = postCommentService.write(post1, "comment2");
            // 2번글에 대한 댓글 3 생성
            PostComment postComment3 = postCommentService.write(post1, "comment3");
        };
    }
}