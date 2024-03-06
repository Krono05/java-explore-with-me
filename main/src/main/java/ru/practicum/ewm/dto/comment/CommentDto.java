package ru.practicum.ewm.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.ewm.dto.photo.PhotoDto;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private Long id;

    private String authorName;

    private String text;

    private String created;

    private int rating;

    private List<PhotoDto> photos;
}
