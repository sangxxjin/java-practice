package org.example.jpa;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public Post writePost(String title, String content) {
        Post post = Post
            .builder()
            .title(title)
            .content(content)
            .build();

        postRepository.save(post);
        return post;
    }

    public long count() {
        return postRepository.count();
    }

    public Optional<Post> findById(long id) {
        return postRepository.findById(id);
    }

    public void modify(Post post, String title, String content) {
        post.setTitle(title);
        post.setContent(content);
    }
}
