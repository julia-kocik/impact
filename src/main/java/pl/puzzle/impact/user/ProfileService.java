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
        return profileRepository.findById(id).map(profile -> {
            if (profileUpdateDTO.getUsername() != null && !profileUpdateDTO.getUsername().isEmpty()) {
                profile.setUsername(profileUpdateDTO.getUsername());
            }
            if (profileUpdateDTO.getPassword() != null && !profileUpdateDTO.getPassword().isEmpty()) {
                profile.setPassword(profileUpdateDTO.getPassword());
            }
            if (profileUpdateDTO.getProfileImage() != null && !profileUpdateDTO.getProfileImage().isEmpty()) {
                profile.setProfileImage(profileUpdateDTO.getProfileImage());
            }
            return profileRepository.save(profile);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
