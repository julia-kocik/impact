package pl.puzzle.impact.event.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.puzzle.impact.event.CreateEventService;
import pl.puzzle.impact.event.Event;
import pl.puzzle.impact.event.EventDetails;
import pl.puzzle.impact.event.UpdateEventService;
import pl.puzzle.impact.event.dto.EventCreateRequest;
import pl.puzzle.impact.event.dto.EventDetailsUpdateRequest;
import java.util.UUID;

@RestController
@RequestMapping("/event")
public class EventController {
    private final CreateEventService createEventService;
    private final UpdateEventService updateEventService;

    public EventController(CreateEventService createEventService, UpdateEventService updateEventService) {
        this.createEventService = createEventService;
        this.updateEventService = updateEventService;
    }
    @PostMapping("/{projectId}")
    public ResponseEntity<Event> createEvent(@RequestBody EventCreateRequest eventCreateRequest, @PathVariable UUID projectId) {
        return ResponseEntity.ok(createEventService.createEvent(eventCreateRequest, projectId));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EventDetails> updateEvent(@PathVariable UUID id, @RequestBody EventDetailsUpdateRequest eventDetailsUpdateRequest) {
        EventDetails updatedEvent = updateEventService.updateEvent(id, eventDetailsUpdateRequest);
        return ResponseEntity.ok(updatedEvent);

    }
}
