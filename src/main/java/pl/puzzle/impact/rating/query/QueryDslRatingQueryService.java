package pl.puzzle.impact.rating.query;

import jakarta.persistence.EntityManager;
import pl.puzzle.impact.common.BaseQueryDslQueryService;
import pl.puzzle.impact.rating.dao.QRating;

public class QueryDslRatingQueryService extends BaseQueryDslQueryService implements RatingQueryService {

    private static final QRating rating = QRating.rating;

    public QueryDslRatingQueryService(EntityManager entityManager) {
        super(entityManager);
    }
}


