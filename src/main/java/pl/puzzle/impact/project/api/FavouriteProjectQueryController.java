package pl.puzzle.impact.project.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.puzzle.impact.project.query.FavouriteProjectQueryService;
import pl.puzzle.impact.project.query.dto.ProjectDetailsProjection;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/favourite-project")
public class FavouriteProjectQueryController {

    private final FavouriteProjectQueryService queryService;

    public FavouriteProjectQueryController(FavouriteProjectQueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ProjectDetailsProjection>> getFavProjectsByUser(@PathVariable UUID userId) {
        List<ProjectDetailsProjection> projects = queryService.getFavProjectsByUser(userId);
        return ResponseEntity.ok(projects);
    }
}
