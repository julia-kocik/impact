package pl.puzzle.impact.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.puzzle.impact.user.dto.UserCreateDto;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "users")
@NoArgsConstructor(access = PRIVATE, force = true)
@AllArgsConstructor(access = PRIVATE)
@Builder
@Getter
public class User {

    @Id
    private final UUID id;

    private boolean active;

    private final LocalDateTime createdAt;

    public static User createUser(UserCreateDto userCreateDto) {
        return User.builder()
                .id(UUID.randomUUID())
                .active(userCreateDto.isActive())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public void activateAccount() {
        this.active = true;
    }

}
