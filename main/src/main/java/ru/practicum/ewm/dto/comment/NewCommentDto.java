package ru.practicum.ewm.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewCommentDto {

    @NotNull
    @Size(min = 50, max = 2000)
    private String text;

    @NotNull
    @Min(1)
    @Max(5)
    private int rating;
}
