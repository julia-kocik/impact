package pl.puzzle.impact.event;

import org.springframework.stereotype.Service;
import pl.puzzle.impact.common.exception.ErrorMessage;
import pl.puzzle.impact.common.exception.NotFoundException;
import pl.puzzle.impact.event.dto.EventDetailsUpdateRequest;
import java.util.UUID;

@Service
public class UpdateEventService {
    private final EventDetailsRepository eventDetailsRepository;

    public UpdateEventService(EventDetailsRepository eventDetailsRepository) {
        this.eventDetailsRepository = eventDetailsRepository;
    }
    public EventDetails updateEvent(UUID id, EventDetailsUpdateRequest eventDetailsUpdateRequest) {
        EventDetails event = eventDetailsRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorMessage.EVENT_NOT_FOUND));
        event.updateEventDetails(eventDetailsUpdateRequest);
        eventDetailsRepository.save(event);
        return event;
    }
}
