package pl.puzzle.impact.project.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.puzzle.impact.project.CreateProjectService;
import pl.puzzle.impact.project.Project;
import pl.puzzle.impact.project.dto.ProjectCreateRequest;

import java.util.UUID;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final CreateProjectService createProjectService;

    public ProjectController(CreateProjectService createProjectService) {
        this.createProjectService = createProjectService;
    }

    @PostMapping("/{companyId}")
    public ResponseEntity<Project> createProject(@RequestBody ProjectCreateRequest projectCreateRequest, @PathVariable UUID companyId) {
        return ResponseEntity.ok(createProjectService.createProject(projectCreateRequest, companyId));
    }
}
