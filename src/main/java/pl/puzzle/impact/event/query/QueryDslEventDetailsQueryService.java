package pl.puzzle.impact.event.query;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import pl.puzzle.impact.common.BaseQueryDslQueryService;
import pl.puzzle.impact.event.QEvent;
import pl.puzzle.impact.event.QEventDetails;
import pl.puzzle.impact.event.query.dto.EventDetailsProjection;
import pl.puzzle.impact.event.query.dto.QEventDetailsProjection;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QueryDslEventDetailsQueryService extends BaseQueryDslQueryService implements EventDetailsQueryService {
    public static final QEventDetails eventDetails = QEventDetails.eventDetails;
    public static final QEvent event = QEvent.event;

    public QueryDslEventDetailsQueryService(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Optional<EventDetailsProjection> getById(UUID eventId) {
        return Optional.ofNullable(queryFactory().select(new QEventDetailsProjection(
                        eventDetails.id,
                        eventDetails.isFeatured,
                        eventDetails.name,
                        eventDetails.startDate,
                        eventDetails.endDate,
                        eventDetails.description
                ))
                .from(eventDetails)
                .where(eventDetails.id.eq(eventId))
                .fetchOne());
    }


    @Override
    public List<EventDetailsProjection> getEventDetailsByProject(UUID projectId) {
        return queryFactory().select(new QEventDetailsProjection(
                        eventDetails.id,
                        eventDetails.isFeatured,
                        eventDetails.name,
                        eventDetails.startDate,
                        eventDetails.endDate,
                        eventDetails.description
                ))
                .from(event)
                .join(eventDetails).on(event.id.eq(eventDetails.id))
                .where(event.projectId.eq(projectId))
                .fetch();
    }
}
