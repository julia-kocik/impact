package pl.puzzle.impact.user.query;

import pl.puzzle.impact.user.query.dto.ProfileProjection;

import java.util.Optional;
import java.util.UUID;

public interface ProfileQueryService {

    Optional<ProfileProjection> getById(UUID profileId);
}
