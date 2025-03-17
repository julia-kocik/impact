package pl.puzzle.impact.comment.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.puzzle.impact.comment.Comment;
import pl.puzzle.impact.comment.CommentService;
import pl.puzzle.impact.comment.dto.CommentCreateRequest;

@RestController
@RequestMapping("/comment")
public class CommentController {
private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Comment> addComment(@RequestBody CommentCreateRequest commentCreateRequest) {
        return ResponseEntity.ok(commentService.addComment(commentCreateRequest));
    }
}
