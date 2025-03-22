package pl.puzzle.impact.comment.query;

import pl.puzzle.impact.common.model.EntityType;
import pl.puzzle.impact.comment.query.dto.CommentProjection;
import pl.puzzle.impact.comment.query.dto.CommentTreeNodeProjection;

import java.util.UUID;
import java.util.List;

public interface CommentQueryService {
    List<CommentProjection> getAllCommentsForEntity(UUID entityId, EntityType entityType);
    List<CommentTreeNodeProjection> getCommentTree(UUID entityId, EntityType entityType);
}
