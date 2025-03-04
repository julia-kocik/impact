package pl.puzzle.impact.user;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import pl.puzzle.impact.common.event.PasswordResetEvent;
import pl.puzzle.impact.common.exception.EmailNotFoundException;
import pl.puzzle.impact.common.exception.IncorrectPasswordException;
import pl.puzzle.impact.token.TokenService;
import pl.puzzle.impact.user.dto.ChangePasswordDto;
import pl.puzzle.impact.user.dto.ProfileUpdateDto;
import pl.puzzle.impact.common.exception.UserNotFoundException;
import pl.puzzle.impact.user.dto.ResetPasswordDto;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final ApplicationEventPublisher eventPublisher;

    public ProfileService(ProfileRepository profileRepository, ApplicationEventPublisher eventPublisher) {
        this.profileRepository = profileRepository;
        this.eventPublisher = eventPublisher;
    }

    public Optional<Profile> getProfileById(UUID id) {
        return profileRepository.findById(id);
    }

    public void requestPasswordReset(String email) {
        Profile profile = profileRepository.findByEmail(email).orElseThrow(EmailNotFoundException::new);

        eventPublisher.publishEvent(new PasswordResetEvent(profile.getId()));
    }

    public Profile updateProfile(UUID id, ProfileUpdateDto profileUpdateDto) {
        Profile profile = profileRepository.findById(id).orElseThrow(UserNotFoundException::new);
        profile.updateProfile(profileUpdateDto);
        profileRepository.save(profile);
        return profile;
    }

    public Profile changePassword(UUID id, ChangePasswordDto changePasswordDto) {
        Profile profile = profileRepository.findById(id).orElseThrow(UserNotFoundException::new);
        if (!changePasswordDto.oldPassword().equals(profile.getPassword())) {
            throw new IncorrectPasswordException();
        }

        profile.changePassword(changePasswordDto.newPassword());
        profileRepository.save(profile);
        return profile;
    }

    public Profile resetPassword(UUID id, ResetPasswordDto resetPasswordDto) {
        Profile profile = profileRepository.findById(id).orElseThrow(UserNotFoundException::new);
        profile.changePassword(resetPasswordDto.newPassword());
        profileRepository.save(profile);
        return profile;
    }
}
