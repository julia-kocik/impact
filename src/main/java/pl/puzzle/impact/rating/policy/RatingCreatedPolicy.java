package pl.puzzle.impact.rating.policy;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.puzzle.impact.rating.event.RatingCreatedEvent;

import java.util.UUID;

@Component
public class RatingCreatedPolicy {

    @EventListener
    public void handleRatingCreatedEvent(RatingCreatedEvent event) {
        switch (event.getSourceType()) {
            case COMPANY -> updateCompanyRating(event.getSourceId());
            case PROJECT -> updateProjectRating(event.getSourceId());
            case EVENT -> updateEventRating(event.getSourceId());
            default -> throw new UnsupportedOperationException();
        }

    }

    private void updateCompanyRating(UUID sourceId) {

    }

    private void updateProjectRating(UUID sourceId) {

    }

    private void updateEventRating(UUID sourceId) {

    }
}
