package pl.puzzle.impact.event.query;

import pl.puzzle.impact.event.query.dto.EventDetailsProjection;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventDetailsQueryService {
    Optional<EventDetailsProjection> getById(UUID imageId);
    List<EventDetailsProjection> getEventDetailsByProject(UUID projectId);
}
