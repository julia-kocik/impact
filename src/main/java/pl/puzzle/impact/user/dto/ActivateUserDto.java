package pl.puzzle.impact.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActivateUserDto {
    private boolean active;

    public ActivateUserDto(boolean active) {
        this.active = active;
    }
}
