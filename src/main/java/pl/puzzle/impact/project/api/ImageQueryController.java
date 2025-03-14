package pl.puzzle.impact.project.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.puzzle.impact.project.query.ImageQueryService;
import pl.puzzle.impact.project.query.dto.ImageProjection;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/image")
public class ImageQueryController {
    private final ImageQueryService imageQueryService;

    public ImageQueryController(ImageQueryService imageQueryService) {
        this.imageQueryService = imageQueryService;
    }

    @GetMapping("/{imageId}")
    public ResponseEntity<ImageProjection> getProjectById(@PathVariable UUID imageId) {
        Optional<ImageProjection> image = imageQueryService.getById(imageId);
        return image.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<ImageProjection>> getImagesByProject(@PathVariable UUID projectId) {
        List<ImageProjection> images = imageQueryService.getImagesByProject(projectId);
        return ResponseEntity.ok(images);
    }
}
