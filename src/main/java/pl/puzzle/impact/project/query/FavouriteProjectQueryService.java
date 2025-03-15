package pl.puzzle.impact.project.query;

import pl.puzzle.impact.project.query.dto.ProjectDetailsProjection;

import java.util.List;
import java.util.UUID;

public interface FavouriteProjectQueryService {
    List<ProjectDetailsProjection> getFavProjectsByUser(UUID userId);
}

