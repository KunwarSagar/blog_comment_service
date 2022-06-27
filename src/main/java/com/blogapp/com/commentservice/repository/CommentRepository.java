package com.blogapp.com.commentservice.repository;

import com.blogapp.com.commentservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostId(Long postId);

//    List<Comment> findByPostId(Long postId);
}
