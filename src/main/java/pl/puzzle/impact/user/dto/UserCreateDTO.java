package pl.puzzle.impact.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDTO {
    private boolean active;

    public UserCreateDTO(boolean active) {
        this.active = active;
    }
}
