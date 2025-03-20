package pl.puzzle.impact.event;

import org.springframework.stereotype.Service;
import pl.puzzle.impact.event.dto.EventCreateRequest;

import java.util.UUID;

@Service
public class CreateEventService {
    private final EventRepository eventRepository;
    private final EventDetailsRepository eventDetailsRepository;


    public CreateEventService(EventRepository eventRepository, EventDetailsRepository eventDetailsRepository) {
        this.eventRepository = eventRepository;
        this.eventDetailsRepository = eventDetailsRepository;
    }

    public Event createEvent(EventCreateRequest eventCreateRequest, UUID projectId) {
        Event event = Event.createEvent(projectId);
        eventRepository.save(event);
        EventDetails eventDetails = EventDetails.createEventDetails(eventCreateRequest, event.getId());
        eventDetailsRepository.save(eventDetails);
        return event;
    }
}

