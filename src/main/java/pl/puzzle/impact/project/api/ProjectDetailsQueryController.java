package pl.puzzle.impact.project.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.puzzle.impact.project.query.ProjectDetailsQueryService;
import pl.puzzle.impact.project.query.dto.ProjectDetailsProjection;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/project")
public class ProjectDetailsQueryController {

    private final ProjectDetailsQueryService queryService;

    public ProjectDetailsQueryController(ProjectDetailsQueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectDetailsProjection>> getAllProjects() {
        List<ProjectDetailsProjection> projects = queryService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDetailsProjection> getProjectById(@PathVariable UUID id) {
        Optional<ProjectDetailsProjection> project = queryService.getById(id);
        return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<ProjectDetailsProjection>> getProjectsByCompanyId(@PathVariable UUID companyId) {
        List<ProjectDetailsProjection> projects = queryService.getProjectsByCompanyId(companyId);
        return ResponseEntity.ok(projects);
    }
}
