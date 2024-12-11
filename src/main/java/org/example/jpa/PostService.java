package org.example.jpa;

import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public Post writePost(String title, String content) {
        Post post = new Post(
            null,
            LocalDateTime.now(),
            LocalDateTime.now(),
            title,
            content,
            false
        );
        postRepository.save(post);
        return post;
    }

    public long count() {
        return postRepository.count();
    }

    public Optional<Post> findById(long id) {
        return postRepository.findById(id);
    }
}
