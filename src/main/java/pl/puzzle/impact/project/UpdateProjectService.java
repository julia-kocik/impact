package pl.puzzle.impact.project;

import org.springframework.stereotype.Service;
import pl.puzzle.impact.common.exception.ErrorMessage;
import pl.puzzle.impact.common.exception.NotFoundException;
import pl.puzzle.impact.project.dto.ProjectDetailsUpdateRequest;

import java.util.UUID;

@Service
public class UpdateProjectService {

    private final ProjectDetailsRepository projectDetailsRepository;

    public UpdateProjectService(ProjectDetailsRepository projectDetailsRepository) {
        this.projectDetailsRepository = projectDetailsRepository;
    }

    public ProjectDetails updateProject(UUID id, ProjectDetailsUpdateRequest projectDetailsUpdateRequest) {
        ProjectDetails project = projectDetailsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.PROJECT_NOT_FOUND));
        project.updateProjectDetails(projectDetailsUpdateRequest);
        projectDetailsRepository.save(project);
        return project;
    }
}
