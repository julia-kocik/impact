package pl.puzzle.impact.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDTO {
    private boolean active;

    public UserUpdateDTO(boolean active) {
        this.active = active;
    }
}
