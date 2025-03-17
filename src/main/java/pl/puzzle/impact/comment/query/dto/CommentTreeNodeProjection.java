package pl.puzzle.impact.comment.query.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import pl.puzzle.impact.comment.CommentEntityType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CommentTreeNodeProjection {

    private UUID id;
    private UUID entityId;
    @Enumerated(EnumType.STRING)
    private CommentEntityType entityType;
    private String content;
    private UUID userId;
    private UUID parentId;
    private LocalDateTime createdAt;
    private List<CommentTreeNodeProjection> replies = new ArrayList<>();

    public CommentTreeNodeProjection(CommentProjection comment) {
        this.id = comment.getId();
        this.entityId = comment.getEntityId();
        this.entityType = comment.getEntityType();
        this.content = comment.getContent();
        this.userId = comment.getUserId();
        this.parentId = comment.getParentId();
        this.createdAt = comment.getCreatedAt();
    }

    public void addReply(CommentTreeNodeProjection reply) {
        this.replies.add(reply);
    }

    public List<CommentTreeNodeProjection> getReplies() {
        return replies;
    }

    public UUID getId() { return id; }
    public UUID getEntityId() { return entityId; }
    public CommentEntityType getEntityType() { return entityType; }
    public String getContent() { return content; }
    public UUID getUserId() { return userId; }
    public UUID getParentId() { return parentId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
