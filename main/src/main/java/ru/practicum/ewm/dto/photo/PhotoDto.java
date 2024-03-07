package ru.practicum.ewm.dto.photo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PhotoDto {

    private String name;

    private String url;

    private String type;

    private long size;
}
