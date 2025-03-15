package pl.puzzle.impact.project.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.puzzle.impact.project.Image;
import pl.puzzle.impact.project.ImageService;
import pl.puzzle.impact.project.dto.ImageCreateRequest;
import pl.puzzle.impact.project.dto.ImageUpdateRequest;

import java.util.UUID;

@RestController
@RequestMapping("/image")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/{projectId}")
    public ResponseEntity<Image> createImage(@RequestBody ImageCreateRequest imageCreateRequest, @PathVariable UUID projectId) {
        return ResponseEntity.ok(imageService.createImage(imageCreateRequest, projectId));
    }

    @PatchMapping("/{imageId}")
    public ResponseEntity<Image> updateImage(@PathVariable UUID imageId, @RequestBody ImageUpdateRequest imageUpdateRequest) {
        Image updatedImage = imageService.updateImage(imageId, imageUpdateRequest);
        return ResponseEntity.ok(updatedImage);
    }
}
