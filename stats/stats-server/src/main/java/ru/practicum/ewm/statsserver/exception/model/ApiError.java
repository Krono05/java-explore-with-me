package ru.practicum.ewm.statsserver.exception.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiError {

    private String status;

    private String reason;

    private String message;

    private String timestamp;
}
