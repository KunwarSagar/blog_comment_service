package com.blogapp.com.commentservice.dtoMapper;

import com.blogapp.com.commentservice.dto.CommentDto;
import com.blogapp.com.commentservice.model.Comment;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentDto CommentToCommentDto(Comment comment);

    @InheritInverseConfiguration
    Comment CommentDtoToComment(CommentDto commentDto);
}
