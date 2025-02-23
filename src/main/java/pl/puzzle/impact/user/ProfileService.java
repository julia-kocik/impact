package pl.puzzle.impact.user;

import org.springframework.stereotype.Service;
import pl.puzzle.impact.user.dto.ProfileUpdateDTO;

import java.util.Optional;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Optional<Profile> getProfileById(Long id) {
        return profileRepository.findById(id);
    }

    public Profile updateProfile(Long id, ProfileUpdateDTO profileUpdateDTO) {
        Profile profile = profileRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        profile.updateProfile(profileUpdateDTO);
        profileRepository.save(profile);
        return profile;
    }
}
