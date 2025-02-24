package pl.puzzle.impact.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileUpdateDto {
    private String username;
    private String email;
    private String password;
    private String profileImage;
}
