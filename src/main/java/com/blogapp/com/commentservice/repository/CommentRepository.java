package com.blogapp.com.commentservice.repository;

import com.blogapp.com.commentservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostId(Long postId);

    Optional<Comment> findByPostIdAndCommentId(Long postId, Long commentId);

//    List<Comment> findByPostId(Long postId);
}
