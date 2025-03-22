package pl.puzzle.impact.event.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.puzzle.impact.event.query.EventDetailsQueryService;
import pl.puzzle.impact.event.query.dto.EventDetailsProjection;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/event")
public class EventDetailsQueryController {
    private final EventDetailsQueryService queryService;

    public EventDetailsQueryController(EventDetailsQueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDetailsProjection> getById(@PathVariable UUID id) {
        Optional<EventDetailsProjection> event = queryService.getById(id);
        return event.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<EventDetailsProjection>> getEventsByProject(@PathVariable UUID projectId) {
        List<EventDetailsProjection> projects = queryService.getEventDetailsByProject(projectId);
        return ResponseEntity.ok(projects);
    }



}
