package ru.practicum.ewm.dto.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practicum.ewm.dto.location.LocationDto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewEventDto {

    @NotBlank
    @Size(min = 20, max = 2000)
    private String annotation;

    @Positive
    private Long category;

    @NotBlank
    @Size(min = 20, max = 7000)
    private String description;

    @NotNull
    private String eventDate;

    @NotNull
    private LocationDto location;

    private boolean paid = false;

    @Min(0)
    private int participantLimit = 0;

    private boolean requestModeration = true;

    @NotBlank
    @Size(min = 3, max = 120)
    private String title;
}
