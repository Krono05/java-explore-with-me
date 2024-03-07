package ru.practicum.ewm.controller.pub;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practicum.ewm.dto.comment.CommentDto;
import ru.practicum.ewm.service.comment.CommentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class CommentPublicController {

    private final CommentService commentService;

    @GetMapping("/events/{eventId}/comments")
    public List<CommentDto> getComments(@PathVariable Long eventId,
                                        @RequestParam(defaultValue = "NEWEST_FIRST") String sort,
                                        @RequestParam(defaultValue = "0") int from,
                                        @RequestParam(defaultValue = "10") int size) {
        return commentService.getComments(eventId, sort, from, size);
    }

    @GetMapping("/events/{eventId}/comments/{commentId}")
    public CommentDto getComment(@PathVariable Long eventId, @PathVariable Long commentId) {
        return commentService.getComment(eventId, commentId);
    }
}
