package pl.puzzle.impact.comment.query;

import pl.puzzle.impact.comment.CommentEntityType;
import pl.puzzle.impact.comment.query.dto.CommentProjection;
import pl.puzzle.impact.comment.query.dto.CommentTreeNodeProjection;

import java.util.UUID;
import java.util.List;

public interface CommentQueryService {
    List<CommentProjection> getAllCommentsForEntity(UUID entityId, CommentEntityType entityType);
    List<CommentTreeNodeProjection> getCommentTree(UUID entityId, CommentEntityType entityType);
}
