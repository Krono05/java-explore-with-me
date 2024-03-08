package ru.practicum.ewm.dto.comment;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.practicum.ewm.model.comment.Comment;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment toComment(NewCommentDto newCommentDto);

    CommentDto toCommentDto(Comment comment);

}