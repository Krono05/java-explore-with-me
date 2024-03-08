package ru.practicum.ewm.dto.comment;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.practicum.ewm.model.comment.Comment;

import static ru.practicum.ewm.util.Constants.DATE_FORMAT;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "event", ignore = true)
    Comment toComment(NewCommentDto newCommentDto);

    CommentDto toCommentDto(Comment comment);

}