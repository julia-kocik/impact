package pl.puzzle.impact.user.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.puzzle.impact.user.query.ProfileQueryService;
import pl.puzzle.impact.user.query.dto.ProfileProjection;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/profile")
public class ProfileQueryController {

    private final ProfileQueryService queryService;

    ProfileQueryController(ProfileQueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileProjection> getProfileById(@PathVariable UUID id) {
        Optional<ProfileProjection> profile = queryService.getById(id);
        return profile.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }
}
