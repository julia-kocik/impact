package pl.puzzle.impact.common;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class BaseQueryDslQueryService {

    @PersistenceContext
    private EntityManager entityManager;

    public BaseQueryDslQueryService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected final JPAQueryFactory queryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}
