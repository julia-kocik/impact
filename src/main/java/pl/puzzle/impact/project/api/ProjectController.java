package pl.puzzle.impact.project.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.puzzle.impact.project.CreateProjectService;
import pl.puzzle.impact.project.Project;
import pl.puzzle.impact.project.ProjectDetails;
import pl.puzzle.impact.project.UpdateProjectService;
import pl.puzzle.impact.project.dto.ProjectCreateRequest;
import pl.puzzle.impact.project.dto.ProjectDetailsUpdateRequest;

import java.util.UUID;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final CreateProjectService createProjectService;
    private final UpdateProjectService updateProjectService;

    public ProjectController(CreateProjectService createProjectService, UpdateProjectService updateProjectService) {
        this.createProjectService = createProjectService;
        this.updateProjectService = updateProjectService;
    }

    @PostMapping("/{companyId}")
    public ResponseEntity<Project> createProject(@RequestBody ProjectCreateRequest projectCreateRequest, @PathVariable UUID companyId) {
        return ResponseEntity.ok(createProjectService.createProject(projectCreateRequest, companyId));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectDetails> updateProject(@PathVariable UUID id, @RequestBody ProjectDetailsUpdateRequest projectDetailsUpdateRequest) {
        ProjectDetails updatedProject = updateProjectService.updateProject(id, projectDetailsUpdateRequest);
        return ResponseEntity.ok(updatedProject);

    }
}
