package pl.puzzle.impact.comment.query.dto;

import com.querydsl.core.annotations.QueryProjection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import pl.puzzle.impact.common.model.EntityType;

import java.time.LocalDateTime;
import java.util.UUID;

public class CommentProjection {

    private final UUID id;

    private final LocalDateTime createdAt;

    private final UUID entityId; // ID of Project/Company

    @Enumerated(EnumType.STRING)
    private EntityType entityType;

    private String content;

    private UUID userId;

    private UUID parentId;

    @QueryProjection
    public CommentProjection(UUID id, LocalDateTime createdAt, UUID entityId, EntityType entityType, String content, UUID userId, UUID parentId) {
        this.id = id;
        this.createdAt = createdAt;
        this.entityId = entityId;
        this.entityType = entityType;
        this.content = content;
        this.userId = userId;
        this.parentId = parentId;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public UUID getEntityId() {
        return entityId;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public String getContent() {
        return content;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getParentId() {
        return parentId;
    }
}
