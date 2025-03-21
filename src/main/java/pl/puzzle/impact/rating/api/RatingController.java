package pl.puzzle.impact.rating.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.puzzle.impact.rating.dao.RatingDao;
import pl.puzzle.impact.rating.dto.RatingCreationRequest;

import java.util.UUID;

@RestController
@RequestMapping("/rating")
public class RatingController {

    private final RatingDao service;

    public RatingController(RatingDao service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UUID> create(@RequestBody RatingCreationRequest request) {
        return ResponseEntity.ok(service.create(request));
    }
}
