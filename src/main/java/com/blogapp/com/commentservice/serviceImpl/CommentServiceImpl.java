package com.blogapp.com.commentservice.serviceImpl;

import com.blogapp.com.commentservice.model.Comment;
import com.blogapp.com.commentservice.model.Comments;
import com.blogapp.com.commentservice.repository.CommentRepository;
import com.blogapp.com.commentservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comments getAllComments(Long postId) {
        List<Comment> commentList = commentRepository.findAllByPostId(postId);
        Comments comments = new Comments();
        comments.setComments(commentList);
        return comments;
    }

    @Override
    public Comment getComment(Long postId, Long commentId) {
        return null;
    }

    @Override
    public Comment addComment(Comment comment) {
        return null;
    }

    @Override
    public Comment updateComment(Comment comment, Long postId) {
        return null;
    }

    @Override
    public Boolean deleteComment(Long commentId) {
        return null;
    }
}
