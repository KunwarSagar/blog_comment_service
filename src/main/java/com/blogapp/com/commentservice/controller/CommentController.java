package com.blogapp.com.commentservice.controller;

import com.blogapp.com.commentservice.dtoMapper.CommentMapper;
import com.blogapp.com.commentservice.exceptions.CommentsNotFoundException;
import com.blogapp.com.commentservice.model.Comment;
import com.blogapp.com.commentservice.model.Comments;
import com.blogapp.com.commentservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
