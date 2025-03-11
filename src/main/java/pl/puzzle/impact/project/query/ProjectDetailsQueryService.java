package pl.puzzle.impact.project.query;

import pl.puzzle.impact.project.query.dto.ProjectDetailsProjection;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectDetailsQueryService {
    List<ProjectDetailsProjection> getAllProjects();
    Optional<ProjectDetailsProjection> getById(UUID projectId);
    List<ProjectDetailsProjection> getProjectsByCompanyId(UUID companyId);
}
