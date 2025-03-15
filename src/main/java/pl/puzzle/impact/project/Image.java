package pl.puzzle.impact.project;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.puzzle.impact.project.dto.ImageCreateRequest;
import pl.puzzle.impact.project.dto.ImageUpdateRequest;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name="image")
@NoArgsConstructor(access = PRIVATE, force = true)
@AllArgsConstructor(access = PRIVATE)
@Builder
@Getter
public class Image {

    @Id
    private final UUID id;

    private final UUID projectId;

    private String imageUrl;

    public static Image createImage(ImageCreateRequest imageCreateRequest, UUID projectId) {
        return Image.builder()
                .id(UUID.randomUUID())
                .projectId(projectId)
                .imageUrl(imageCreateRequest.imageUrl())
                .build();
    }

    public static Image createImage(UUID projectId) {
        return Image.builder()
                .id(UUID.randomUUID())
                .projectId(projectId)
                .imageUrl("/profileImage")
                .build();
    }


    void updateImage(ImageUpdateRequest imageUpdateRequest) {
        this.imageUrl = imageUpdateRequest.imageUrl();
    }
}
