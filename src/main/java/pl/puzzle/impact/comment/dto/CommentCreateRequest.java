package pl.puzzle.impact.comment.dto;
import pl.puzzle.impact.comment.CommentEntityType;

import java.util.UUID;

public record CommentCreateRequest(
        UUID entityId,
        CommentEntityType entityType,
        String content,
        UUID userId,
        UUID parentId
) {}
