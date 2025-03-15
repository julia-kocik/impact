package pl.puzzle.impact.project;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "favourite_project")
@NoArgsConstructor(access = PRIVATE, force = true)
@AllArgsConstructor(access = PRIVATE)
@Builder
@Getter
public class FavouriteProject {

    @Id
    private UUID id;

    private UUID userId;

    private UUID projectId;

    public static FavouriteProject addProjectToFavourites(UUID userId, UUID projectId) {
        return FavouriteProject.builder()
                .id(UUID.randomUUID())
                .userId(userId)
                .projectId(projectId)
                .build();
    }
}