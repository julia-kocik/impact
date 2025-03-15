package pl.puzzle.impact.project.query;

import pl.puzzle.impact.project.query.dto.ImageProjection;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ImageQueryService {
    Optional<ImageProjection> getById(UUID imageId);
    List<ImageProjection> getImagesByProject(UUID projectId);
}
