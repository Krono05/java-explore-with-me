package ru.practicum.ewm.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParticipationRequestDto {

    private Long id;

    private String created;

    private Long event;

    private Long requester;

    private String status;
}
