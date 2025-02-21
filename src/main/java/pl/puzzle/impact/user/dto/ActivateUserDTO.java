package pl.puzzle.impact.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActivateUserDTO {
    private boolean active;

    public ActivateUserDTO(boolean active) {
        this.active = active;
    }
}
