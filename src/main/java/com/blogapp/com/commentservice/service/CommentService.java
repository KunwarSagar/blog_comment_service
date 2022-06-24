package com.blogapp.com.commentservice.service;

import com.blogapp.com.commentservice.model.Comment;
import com.blogapp.com.commentservice.model.Comments;

import java.util.Collection;

public interface CommentService {
    Comments getAllComments(Long postId);
    Comment getComment(Long postId, Long commentId);
    Comment addComment(Comment comment);
    Comment updateComment(Comment comment);
    Boolean deleteComment(Long commentId);
}
