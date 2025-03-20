package pl.puzzle.impact.event;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "event")
@NoArgsConstructor(access = PRIVATE, force = true)
@AllArgsConstructor(access = PRIVATE)
@Builder
@Getter
public class Event {

    @Id
    private UUID id;

    private final LocalDateTime createdAt;

    private final UUID projectId;

    public static Event createEvent(UUID projectId) {
        return Event.builder()
                .id(UUID.randomUUID())
                .createdAt(LocalDateTime.now())
                .projectId(projectId)
                .build();
    }
}
