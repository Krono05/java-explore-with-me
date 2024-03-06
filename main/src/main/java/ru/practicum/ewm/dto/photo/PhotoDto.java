package ru.practicum.ewm.dto.photo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotoDto {

    private String name;

    private String url;

    private String type;

    private long size;
}
