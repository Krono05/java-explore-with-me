package ru.practicum.ewm.model.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practicum.ewm.model.category.Category;
import ru.practicum.ewm.model.comment.Comment;
import ru.practicum.ewm.model.compilation.Compilation;
import ru.practicum.ewm.model.location.Location;
import ru.practicum.ewm.model.request.Request;
import ru.practicum.ewm.model.user.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    @Column(nullable = false, length = 120)
    private String title;

    @Column(nullable = false, length = 2000)
    private String annotation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(nullable = false, length = 7000)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "initiator_id")
    private User initiator;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "published_on")
    private LocalDateTime publishedOn;

    @Column(name = "event_date")
    private LocalDateTime eventDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "participant_limit")
    private int participantLimit;

    @Column(name = "request_moderation")
    private boolean requestModeration;

    @Column(name = "confirmed_requests")
    private Integer confirmedRequests;

    @Column
    private boolean paid;

    @Enumerated(EnumType.STRING)
    private EventState state;

    @ManyToMany(mappedBy = "events")
    private List<Compilation> compilations;

    @OneToMany(mappedBy = "event")
    private List<Request> requests;

    @OneToMany(mappedBy = "event")
    private List<Comment> comments;

    @Column
    private Long views;

    @Column(precision = 2, scale = 1)
    private BigDecimal rating;
}
