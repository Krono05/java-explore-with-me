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
////
//    public static Comment toComment(NewCommentDto newCommentDto) {
//        return new Comment(
//                null,
//                newCommentDto.getText(),
//                null,
//                null,
//                null,
//                newCommentDto.getRating()
//
//        );
//    }
//
//    public static CommentDto toCommentDto(Comment comment) {
//        return new CommentDto(
//                comment.getId(),
//                comment.getAuthor().getName(),
//                comment.getText(),
//                comment.getCreated().format(DATE_FORMAT),
//                comment.getRating()
//        );
//    }
//}