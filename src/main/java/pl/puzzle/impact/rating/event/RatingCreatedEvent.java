package pl.puzzle.impact.rating.event;

import org.springframework.context.ApplicationEvent;
import pl.puzzle.impact.common.model.EntityType;

import java.util.UUID;

public class RatingCreatedEvent extends ApplicationEvent {

    private final EntityType sourceType;

    public RatingCreatedEvent(UUID sourceId, EntityType sourceType) {
        super(sourceId);
        this.sourceType = sourceType;
    }

    public UUID getSourceId() {
        return (UUID) source;
    }

    public EntityType getSourceType() {
        return sourceType;
    }
}
