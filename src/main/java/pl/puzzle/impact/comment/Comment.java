package pl.puzzle.impact.comment;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.puzzle.impact.comment.dto.CommentCreateRequest;
import pl.puzzle.impact.common.model.EntityType;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "comment")
@NoArgsConstructor(access = PRIVATE, force = true)
@AllArgsConstructor(access = PRIVATE)
@Builder
@Getter
public class Comment {

    @Id
    private final UUID id;

    private final LocalDateTime createdAt;

    private final UUID entityId; // ID of Project/Company

    @Enumerated(EnumType.STRING)
    private EntityType entityType;

    private String content;

    private UUID userId;

    private UUID parentId;

    public static Comment addComment(CommentCreateRequest commentCreateRequest) {
        return Comment.builder()
                .id(UUID.randomUUID())
                .createdAt(LocalDateTime.now())
                .entityId(commentCreateRequest.entityId())
                .entityType(commentCreateRequest.entityType())
                .content(commentCreateRequest.content())
                .userId(commentCreateRequest.userId())
                .parentId(commentCreateRequest.parentId())
                .build();
    }
}
