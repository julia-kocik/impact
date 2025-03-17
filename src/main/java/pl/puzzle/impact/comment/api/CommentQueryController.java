package pl.puzzle.impact.comment.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.puzzle.impact.comment.CommentEntityType;
import pl.puzzle.impact.comment.query.CommentQueryService;
import pl.puzzle.impact.comment.query.dto.CommentTreeNodeProjection;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/comment")
public class CommentQueryController {

    private final CommentQueryService commentQueryService;

    public CommentQueryController(CommentQueryService commentQueryService) {
        this.commentQueryService = commentQueryService;
    }

    @GetMapping("/{entityType}/{entityId}")
    public ResponseEntity<List<CommentTreeNodeProjection>> getCommentsTree(
            @PathVariable CommentEntityType entityType,
            @PathVariable UUID entityId) {
        List<CommentTreeNodeProjection> commentTree = commentQueryService.getCommentTree(entityId, entityType);
        return ResponseEntity.ok(commentTree);
    }

}
