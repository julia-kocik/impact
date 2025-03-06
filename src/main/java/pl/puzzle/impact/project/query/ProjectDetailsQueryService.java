package pl.puzzle.impact.project.query;

import pl.puzzle.impact.project.query.dto.ProjectDetailsProjection;
import java.util.Optional;
import java.util.UUID;

public interface ProjectDetailsQueryService {
    Optional<ProjectDetailsProjection> getById(UUID projectId);
}
