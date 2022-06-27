package com.blogapp.com.commentservice.controller;

import com.blogapp.com.commentservice.dto.CommentDto;
import com.blogapp.com.commentservice.dtoMapper.CommentMapper;
import com.blogapp.com.commentservice.exceptions.CommentAddFailedException;
import com.blogapp.com.commentservice.exceptions.CommentsNotFoundException;
import com.blogapp.com.commentservice.model.Comment;
import com.blogapp.com.commentservice.model.Comments;
import com.blogapp.com.commentservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/comments")
public class CommentController {

    CommentService commentService;
    CommentMapper commentMapper;

    @Autowired
    public CommentController(CommentService commentService, CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    @GetMapping("/{postId}")
    public ResponseEntity<?> getComments(@PathVariable("postId") Long postId){
        Comments comments = commentService.getAllComments(postId);

        if(comments.size() > 0){
            return new ResponseEntity<>(comments, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new CommentsNotFoundException("Comments of post id "+ postId + " not found").getMessage() ,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{postId}/{commentId}")
    public ResponseEntity<?> getCommment(@PathVariable("postId")  Long postId, @PathVariable("commentId") Long commentId){
        Comment comment = commentService.getComment(postId, commentId);

        if(comment != null){
            return new ResponseEntity<>(comment, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new CommentsNotFoundException("Comment with "+postId+" for post id "+postId +" not found."), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{postId}")
    public ResponseEntity<?> addComment(@Valid @RequestBody CommentDto commentDto){
        Comment comment = commentMapper.CommentDtoToComment(commentDto);
        Comment addedComment = commentService.addComment(comment);

        if(addedComment != null){
            return new ResponseEntity<>(addedComment, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new CommentAddFailedException("comment add failed.").getMessage(), HttpStatus.CONFLICT);
        }
    }
}
