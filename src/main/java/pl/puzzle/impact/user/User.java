package pl.puzzle.impact.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.puzzle.impact.user.dto.UserCreateDTO;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "users")
@NoArgsConstructor(access = PRIVATE, force = true)
@AllArgsConstructor(access = PRIVATE)
@Builder
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    private boolean active;

    private final LocalDateTime createdAt;

    public static User createUser(UserCreateDTO userCreateDTO) {
        return User.builder()
                .active(userCreateDTO.isActive())
                .createdAt(LocalDateTime.now())
                .build();
    }

    void setActive(boolean active) {
        this.active = active;
    }

}
