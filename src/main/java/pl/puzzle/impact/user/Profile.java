package pl.puzzle.impact.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.puzzle.impact.user.dto.ProfileUpdateDto;
import pl.puzzle.impact.user.dto.UserCreateDto;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "profile")
@NoArgsConstructor(access = PRIVATE, force = true)
@AllArgsConstructor(access = PRIVATE)
@Builder
@Getter
public class Profile {
    @Id
    private UUID id;

    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String profileImage;

    public static Profile createProfile(UserCreateDto profileCreateDto, UUID userId) {
        return Profile.builder()
                .id(userId)
                .username(profileCreateDto.getUsername())
                .email(profileCreateDto.getEmail())
                .password(profileCreateDto.getPassword())
                .profileImage(profileCreateDto.getProfileImage())
                .build();
    }

    void updateProfile(ProfileUpdateDto profileUpdateDto) {
        this.username = profileUpdateDto.getUsername();
        this.email = profileUpdateDto.getEmail();
        this.password = profileUpdateDto.getPassword();
    }

   public void changePassword(String password) {
        this.password = password;
    }
}
