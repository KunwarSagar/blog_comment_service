package com.blogapp.com.commentservice.dto;

import javax.validation.constraints.NotNull;

public class CommentDto {

    @NotNull
    private Long userId;
    @NotNull
    private Long postId;
    @NotNull
    private String comment;
}
