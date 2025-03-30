package pl.puzzle.impact.rating.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import pl.puzzle.impact.rating.dto.RatingCreationRequest;
import pl.puzzle.impact.rating.event.RatingCreatedEvent;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RatingDao {

    private final RatingRepository repository;
    private final ApplicationEventPublisher publisher;

    public UUID create(RatingCreationRequest request) {
        var rating = repository.save(new Rating(request));

        publisher.publishEvent(new RatingCreatedEvent(rating.sourceId, rating.getSourceType()));

        return rating.getId();
    }

    float getAverageRatingFor(UUID sourceId) {
        return repository.getAverageRatingFor(sourceId);
    }
}