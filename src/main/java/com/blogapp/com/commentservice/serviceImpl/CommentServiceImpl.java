package com.blogapp.com.commentservice.serviceImpl;

import com.blogapp.com.commentservice.model.Comment;
import com.blogapp.com.commentservice.model.Comments;
import com.blogapp.com.commentservice.repository.CommentRepository;
import com.blogapp.com.commentservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    /**
     * Get all comments of the specific post
     * @param postId
     * @return Comments
     */
    @Override
    public Comments getAllComments(Long postId) {
        List<Comment> commentList = commentRepository.findAllByPostId(postId);
        Comments comments = new Comments();
        comments.setComments(commentList);
        return comments;
    }

    /**
     * Get single comment of a post by comment id
     * @param postId
     * @param commentId
     * @return Comment on success or else throw illegal state exception
     */
    @Override
    public Comment getComment(Long postId, Long commentId) {
        Comment comment = commentRepository.findByPostIdAndCommentId(postId,commentId)
                .orElseThrow(()-> new IllegalStateException("Comment with comment id "+commentId+" for post id "+postId +" not found."));
        return comment;
    }

    /**
     * Add comment
     * @param comment
     * @return added comment
     */
    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    /**
     * Update comment by comment id
     * @param comment
     * @param commentId
     * @return updated comment on success or else throw illegal state exception
     */
    @Override
    public Comment updateComment(Comment comment,Long postId, Long commentId) {
        Comment existingComment = commentRepository.findByPostIdAndCommentId(postId, commentId)
                .orElseThrow(()-> new IllegalStateException("Comment with comment id "+commentId+"  for post id "+postId +" not found."));
        existingComment.setValues(comment);
        return commentRepository.save(existingComment);
    }

    /**
     * Delete comment by comment id
     * @param postId
     * @param commentId
     * @return boolean
     */
    @Override
    public Boolean deleteComment(Long postId, Long commentId) {
        Optional<Comment> comment = commentRepository.findByPostIdAndCommentId(postId, commentId);
        if(!comment.isPresent()){
            return false;
        }else {
            commentRepository.delete(comment.get());
            return true;
        }
    }
}
