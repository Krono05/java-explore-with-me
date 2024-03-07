package ru.practicum.ewm.controller.priv;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.dto.event.EventFullDto;
import ru.practicum.ewm.dto.event.EventShortDto;
import ru.practicum.ewm.dto.event.NewEventDto;
import ru.practicum.ewm.dto.event.UpdateEventUserRequestDto;
import ru.practicum.ewm.dto.request.EventRequestStatusUpdateRequestDto;
import ru.practicum.ewm.dto.request.EventRequestStatusUpdateResultDto;
import ru.practicum.ewm.dto.request.ParticipationRequestDto;
import ru.practicum.ewm.service.event.EventService;
import ru.practicum.ewm.service.request.RequestService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class EventPrivateController {

    private final EventService eventService;
    private final RequestService requestService;

    @GetMapping("/users/{userId}/events")
    public List<EventShortDto> getEventsAddedByUser(@PathVariable Long userId,
                                                      @RequestParam(defaultValue = "0") int from,
                                                      @RequestParam(defaultValue = "10") int size) {
        return eventService.getEventsAddedByUser(userId, from, size);
    }

    @GetMapping("/users/{userId}/events/{eventId}")
    public EventFullDto getEventAddedByUser(@PathVariable Long userId, @PathVariable Long eventId) {
        return eventService.getEventAddedByUser(userId, eventId);
    }

    @PostMapping("/users/{userId}/events")
    @ResponseStatus(HttpStatus.CREATED)
    public EventFullDto addEvent(@PathVariable Long userId, @Validated @RequestBody NewEventDto newEventDto) {
        return eventService.addEvent(userId, newEventDto);
    }

    @PatchMapping("/users/{userId}/events/{eventId}")
    public EventFullDto editEventAddedByUser(@PathVariable Long userId, @PathVariable Long eventId,
                                               @Validated @RequestBody UpdateEventUserRequestDto updateEventUserRequestDto) {
        return eventService.editEventAddedByUser(userId, eventId, updateEventUserRequestDto);
    }

    @GetMapping("/users/{userId}/events/{eventId}/requests")
    public List<ParticipationRequestDto> getRequestsForAddedEventByUser(@PathVariable Long userId,
                                                                          @PathVariable Long eventId) {
        return requestService.getRequestsForAddedEventByUser(userId, eventId);
    }

    @PatchMapping("/users/{userId}/events/{eventId}/requests")
    public EventRequestStatusUpdateResultDto editRequestStatusForAddedEventByUser(@PathVariable Long userId, @PathVariable Long eventId,
                                                                                  @RequestBody EventRequestStatusUpdateRequestDto eventRequestStatusUpdateRequestDto) {
        return requestService.editRequestStatusForAddedEventByUser(userId, eventId, eventRequestStatusUpdateRequestDto);
    }

}
