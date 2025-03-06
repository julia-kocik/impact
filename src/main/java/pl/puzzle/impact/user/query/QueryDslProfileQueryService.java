package pl.puzzle.impact.user.query;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import pl.puzzle.impact.common.BaseQueryDslQueryService;
import pl.puzzle.impact.user.QProfile;
import pl.puzzle.impact.user.QUser;
import pl.puzzle.impact.user.query.dto.ProfileProjection;
import pl.puzzle.impact.user.query.dto.QProfileProjection;
import java.util.Optional;
import java.util.UUID;

@Service
class QueryDslProfileQueryService extends BaseQueryDslQueryService implements ProfileQueryService {

    private static final QProfile profile = QProfile.profile;
    private static final QUser user = QUser.user;

    QueryDslProfileQueryService(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Optional<ProfileProjection> getById(UUID profileId) {
        return Optional.ofNullable(queryFactory().select(new QProfileProjection(
                        profile.username,
                        profile.email,
                        profile.password,
                        user.active,
                        profile.profileImage
                ))
                .from(profile)
                .join(user).on(user.id.eq(profileId))
                .where(profile.id.eq(profileId))
                .fetchOne());
    }
}
