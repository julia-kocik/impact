package pl.puzzle.impact.comment.dto;
import pl.puzzle.impact.common.model.EntityType;

import java.util.UUID;

public record CommentCreateRequest(
        UUID entityId,
        EntityType entityType,
        String content,
        UUID userId,
        UUID parentId
) {}
