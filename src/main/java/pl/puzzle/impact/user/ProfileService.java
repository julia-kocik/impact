package pl.puzzle.impact.user;

import org.springframework.stereotype.Service;
import pl.puzzle.impact.user.dto.ProfileUpdateDto;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Optional<Profile> getProfileById(UUID id) {
        return profileRepository.findById(id);
    }

    public Profile updateProfile(UUID id, ProfileUpdateDto profileUpdateDto) {
        Profile profile = profileRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        profile.updateProfile(profileUpdateDto);
        profileRepository.save(profile);
        return profile;
    }
}
