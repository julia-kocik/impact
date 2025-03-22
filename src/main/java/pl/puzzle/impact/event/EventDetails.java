package pl.puzzle.impact.event;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.puzzle.impact.event.dto.EventCreateRequest;
import pl.puzzle.impact.event.dto.EventDetailsUpdateRequest;
import java.time.LocalDateTime;
import java.util.UUID;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "event_details")
@NoArgsConstructor(access = PRIVATE, force = true)
@AllArgsConstructor(access = PRIVATE)
@Builder
@Getter
public class EventDetails {

    @Id
    private final UUID id;

    private boolean isFeatured;

    private String name;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String description;

    static EventDetails createEventDetails(EventCreateRequest projectCreateRequest, UUID eventId) {
        return EventDetails.builder()
                .id(eventId)
                .isFeatured(projectCreateRequest.isFeatured())
                .name(projectCreateRequest.name())
                .startDate(projectCreateRequest.startDate())
                .endDate(projectCreateRequest.endDate())
                .description(projectCreateRequest.description())
                .build();
    }

    void updateEventDetails(EventDetailsUpdateRequest projectDetailsUpdateRequest) {
        this.isFeatured = projectDetailsUpdateRequest.isFeatured();
        this.name = projectDetailsUpdateRequest.name();
        this.startDate = projectDetailsUpdateRequest.startDate();
        this.endDate = projectDetailsUpdateRequest.endDate();
        this.description = projectDetailsUpdateRequest.description();
    }

}