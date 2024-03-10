package ru.practicum.ewm.dto.comment;

import lombok.experimental.UtilityClass;
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
    Comment toComment(NewCommentDto newCommentDto);

    @Mapping(target = "authorName", source = "author.name")
    @Mapping(target = "created", source = "created", dateFormat = "yyyy-MM-dd HH:mm:ss")
    CommentDto toCommentDto(Comment comment);
}

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