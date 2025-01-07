package org.example.jpa.post.comment;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.jpa.post.post.Post;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostCommentService {
    private final PostCommentRepository postCommentRepository;
    public PostComment write(Post post, String content) {
        PostComment postComment = PostComment.builder()
            .post(post)
            .content(content)
            .build();
        return postCommentRepository.save(postComment);
    }
    public Optional<PostComment> findById(long id) {
        return postCommentRepository.findById(id);
    }
}