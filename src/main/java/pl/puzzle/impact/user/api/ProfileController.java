package pl.puzzle.impact.user.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.puzzle.impact.user.Profile;
import pl.puzzle.impact.user.ProfileService;
import pl.puzzle.impact.user.dto.ProfileUpdateDto;

import java.util.UUID;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private final ProfileService profileService;

    ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable UUID id, @RequestBody ProfileUpdateDto profileUpdateDto) {
        try {
            Profile updatedProfile = profileService.updateProfile(id, profileUpdateDto);
            return ResponseEntity.ok(updatedProfile);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
