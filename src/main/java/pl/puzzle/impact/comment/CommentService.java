package pl.puzzle.impact.comment;

import org.springframework.stereotype.Service;
import pl.puzzle.impact.comment.dto.CommentCreateRequest;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment addComment(CommentCreateRequest commentCreateRequest) {
        Comment comment = Comment.addComment(commentCreateRequest);
        return commentRepository.save(comment);
    }
}
