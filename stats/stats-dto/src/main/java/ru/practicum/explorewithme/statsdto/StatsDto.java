package ru.practicum.explorewithme.statsdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatsDto {

    private String app;
    private String uri;
    private Long hits;
}
