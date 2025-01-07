package org.example.jpa.post.comment;

import org.springframework.data.jpa.repository.JpaRepository;
public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
}