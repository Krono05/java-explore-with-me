package ru.practicum.ewm.dto.compilation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewCompilationDto {

    @NotNull
    @NotBlank
    @Size(min = 1, max = 50)
    private String title;

    private Boolean pinned = false;

    private List<Long> events;
}
