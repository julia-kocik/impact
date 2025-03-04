package pl.puzzle.impact.user;

import org.springframework.stereotype.Service;
import pl.puzzle.impact.common.exception.EmailNotFoundException;
import pl.puzzle.impact.common.exception.IncorrectPasswordException;
import pl.puzzle.impact.user.dto.SendTokenDto;
import pl.puzzle.impact.user.dto.ChangePasswordDto;
import pl.puzzle.impact.user.dto.ProfileUpdateDto;
import pl.puzzle.impact.common.exception.UserNotFoundException;
import pl.puzzle.impact.user.dto.ResetPasswordDto;
import java.util.Optional;
import java.util.UUID;

//todo exception subjects to change
@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final TokenService tokenService;

    ProfileService(ProfileRepository profileRepository, TokenService tokenService) {
        this.profileRepository = profileRepository;
        this.tokenService = tokenService;
    }

    public Optional<Profile> getProfileById(UUID id) {
        return profileRepository.findById(id);
    }

    public Token sendToken(SendTokenDto sendTokenDto) {
        Profile profile = profileRepository.findByEmail(sendTokenDto.email()).orElseThrow(EmailNotFoundException::new);
        return tokenService.sendToken(profile.getId(), sendTokenDto.type());
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
