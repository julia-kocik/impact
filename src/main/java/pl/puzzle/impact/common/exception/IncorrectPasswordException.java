package pl.puzzle.impact.common.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException(ErrorMessage message) {
        super(message.toString());
    }
}
