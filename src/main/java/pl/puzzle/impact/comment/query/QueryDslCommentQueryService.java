package pl.puzzle.impact.comment.query;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import pl.puzzle.impact.comment.CommentEntityType;
import pl.puzzle.impact.comment.QComment;
import pl.puzzle.impact.comment.query.dto.CommentProjection;
import pl.puzzle.impact.comment.query.dto.CommentTreeNodeProjection;
import pl.puzzle.impact.comment.query.dto.QCommentProjection;
import pl.puzzle.impact.common.BaseQueryDslQueryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
class QueryDslCommentQueryService extends BaseQueryDslQueryService implements CommentQueryService {

    public static final QComment comment = QComment.comment;

    public QueryDslCommentQueryService(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<CommentProjection> getAllCommentsForEntity(UUID entityId, CommentEntityType entityType) {

        return queryFactory().select(new QCommentProjection(
                        comment.id,
                        comment.createdAt,
                        comment.entityId,
                        comment.entityType,
                        comment.content,
                        comment.userId,
                        comment.parentId
                )).from(comment)
                .where(comment.entityId.eq(entityId)
                        .and(comment.entityType.eq(entityType)))
                .orderBy(comment.createdAt.asc())
                .fetch();
    }

    public List<CommentTreeNodeProjection> getCommentTree(UUID entityId, CommentEntityType entityType) {
        List<CommentProjection> comments = getAllCommentsForEntity(entityId, entityType);
        return buildCommentTree(comments);
    }

    private List<CommentTreeNodeProjection> buildCommentTree(List<CommentProjection> comments) {
        Map<UUID, CommentTreeNodeProjection> commentMap = new HashMap<>();
        List<CommentTreeNodeProjection> rootComments = new ArrayList<>();

        for (CommentProjection singleComment : comments) {
            commentMap.put(singleComment.getId(), new CommentTreeNodeProjection(singleComment));
        }

        for (CommentProjection singleComment : comments) {
            if (singleComment.getParentId() != null) {
                CommentTreeNodeProjection parent = commentMap.get(singleComment.getParentId());
                if (parent != null) {
                    parent.addReply(commentMap.get(singleComment.getId()));
                }
            } else {
                rootComments.add(commentMap.get(singleComment.getId()));
            }
        }
        return rootComments;
    }
}
