package pl.puzzle.impact.user.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.puzzle.impact.user.Profile;
import pl.puzzle.impact.user.ProfileService;
import pl.puzzle.impact.user.Token;
import pl.puzzle.impact.user.TokenService;
import pl.puzzle.impact.user.dto.ChangePasswordDto;
import pl.puzzle.impact.user.dto.ProfileUpdateDto;
import pl.puzzle.impact.user.dto.ResetPasswordDto;
import pl.puzzle.impact.user.dto.SendTokenDto;

import java.util.UUID;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private final ProfileService profileService;
    private final TokenService tokenService;

    public ProfileController(ProfileService profileService, TokenService tokenService) {
        this.profileService = profileService;
        this.tokenService = tokenService;
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

    @PatchMapping("/change-password/{id}")
    public ResponseEntity<Profile> changePassword(@PathVariable UUID id, @RequestBody ChangePasswordDto changePasswordDto) {
        try {
            Profile profileAfterPasswordChange = profileService.changePassword(id, changePasswordDto);
            return ResponseEntity.ok(profileAfterPasswordChange);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // sendToken
    @PostMapping("/start-reset")
    public ResponseEntity<Token> sendToken(@RequestBody SendTokenDto sendTokenDto) {
        return ResponseEntity.ok(profileService.sendToken(sendTokenDto));
    }

    // after validation redirect to password reset view
    @GetMapping("reset-password/{tokenCode}")
    public boolean validateToken(@PathVariable String tokenCode) {
        return tokenService.validateToken(tokenCode);
    }

    // reset
    @PatchMapping("/reset-password/{id}")
    public ResponseEntity<Profile> resetPassword(@PathVariable UUID id, @RequestBody ResetPasswordDto resetPasswordDto) {
        try {
            Profile profileAfterPasswordReset = profileService.resetPassword(id, resetPasswordDto);
            return ResponseEntity.ok(profileAfterPasswordReset);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
