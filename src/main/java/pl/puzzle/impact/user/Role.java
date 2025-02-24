package pl.puzzle.impact.user;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.puzzle.impact.user.dto.RoleCreateDTO;
import pl.puzzle.impact.user.dto.RoleUpdateDTO;

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

    public static Role createRole(RoleCreateDTO roleCreateDTO, UUID userId) {
        return Role.builder()
                .id(UUID.randomUUID())
                .userId(userId)
                .type(roleCreateDTO.getType())
                .build();
    }

    public static Role createRole(UUID userId) {
        return Role.builder()
                .id(UUID.randomUUID())
                .userId(userId)
                .type("ADMIN")
                .build();
    }

    void updateRole(RoleUpdateDTO roleUpdateDTO) {
        this.type = roleUpdateDTO.getType();
    }
}
