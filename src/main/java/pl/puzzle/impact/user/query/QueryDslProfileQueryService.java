package pl.puzzle.impact.user.query;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import pl.puzzle.impact.user.QProfile;
import pl.puzzle.impact.user.query.dto.ProfileProjection;
import pl.puzzle.impact.user.query.dto.QProfileProjection;

import java.util.Optional;
import java.util.UUID;

@Service
class QueryDslProfileQueryService implements ProfileQueryService {

    @PersistenceContext
    private EntityManager entityManager;

    private static final QProfile profile = QProfile.profile;

    QueryDslProfileQueryService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<ProfileProjection> getById(UUID profileId) {
        var queryFactory = new JPAQueryFactory(entityManager);

        var query = queryFactory.select(new QProfileProjection(
                profile.username,
                profile.email,
                profile.password
        ))
                .from(profile)
                .where(profile.id.eq(profileId));

        return Optional.ofNullable(query.fetchOne());
    }
}
