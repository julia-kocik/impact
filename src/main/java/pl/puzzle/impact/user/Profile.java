package pl.puzzle.impact.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.puzzle.impact.user.dto.UserCreateDTO;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "profile")
@NoArgsConstructor(access = PRIVATE, force = true)
@AllArgsConstructor(access = PRIVATE)
@Builder
@Getter
public class Profile {
    @Id
    private Long id;

    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String profileImage;

    public static Profile createProfile(UserCreateDTO profileCreateDTO, Long userId) {
        return Profile.builder()
                .id(userId)
                .username(profileCreateDTO.getUsername())
                .email(profileCreateDTO.getEmail())
                .password(profileCreateDTO.getPassword())
                .profileImage(profileCreateDTO.getProfileImage())
                .build();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
