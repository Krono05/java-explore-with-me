package ru.practicum.ewm.statsserver.model.stats;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Stats {

    private String app;

    private String uri;

    private Long hits;
}
