package pl.puzzle.impact.project.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.puzzle.impact.project.FavouriteProject;
import pl.puzzle.impact.project.FavouriteProjectService;

import java.util.UUID;

@RestController
@RequestMapping("/favourite-project")
public class FavouriteProjectController {
    private final FavouriteProjectService favouriteProjectService;

    public FavouriteProjectController(FavouriteProjectService favouriteProjectService) {
        this.favouriteProjectService = favouriteProjectService;
    }

    @PostMapping("/{userId}/{projectId}")
    public ResponseEntity<FavouriteProject> addProjectToFavourites(@PathVariable UUID userId, @PathVariable UUID projectId) {
        return ResponseEntity.ok(favouriteProjectService.addProjectToFavourites(userId, projectId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectFromFavourites(@PathVariable UUID id) {
        favouriteProjectService.deleteProjectFromFavourites(id);
        return ResponseEntity.noContent().build();
    }
}
