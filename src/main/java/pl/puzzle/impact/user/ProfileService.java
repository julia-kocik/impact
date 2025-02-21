package pl.puzzle.impact.user;

import org.springframework.stereotype.Service;
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
}
