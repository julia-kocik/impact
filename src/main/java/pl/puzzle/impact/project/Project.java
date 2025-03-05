package pl.puzzle.impact.project;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "project")
@NoArgsConstructor(access = PRIVATE, force = true)
@AllArgsConstructor(access = PRIVATE)
@Builder
@Getter
public class Project {

    private final LocalDateTime createdAt;
    @Id
    private UUID id;

    public static Project createProject() {
        return Project.builder()
                .id(UUID.randomUUID())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
