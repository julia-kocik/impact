package pl.puzzle.impact.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.puzzle.impact.user.dto.RoleCreateDto;
import pl.puzzle.impact.user.dto.RoleUpdateDto;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name="role")
@NoArgsConstructor(access = PRIVATE, force = true)
@AllArgsConstructor(access = PRIVATE)
@Builder
@Getter
public class Role {
    @Id
    private final UUID id;

    private final UUID userId;

    private String type;

    public static Role createRole(RoleCreateDto roleCreateDto, UUID userId) {
        return Role.builder()
                .id(UUID.randomUUID())
                .userId(userId)
                .type(roleCreateDto.getType())
                .build();
    }

    public static Role createRole(UUID userId) {
        return Role.builder()
                .id(UUID.randomUUID())
                .userId(userId)
                .type("ADMIN")
                .build();
    }

    void updateRole(RoleUpdateDto roleUpdateDto) {
        this.type = roleUpdateDto.getType();
    }
}
