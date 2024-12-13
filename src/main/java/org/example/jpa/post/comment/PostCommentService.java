package org.example.jpa.post.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostCommentService {
    private final PostCommentRepository postCommentRepository;
    public PostComment write(long postId, String content) {
        PostComment postComment = PostComment.builder()
            .postId(postId)
            .content(content)
            .build();
        return postCommentRepository.save(postComment);
    }
}