package pl.puzzle.impact.common.event;

import org.springframework.context.ApplicationEvent;

import java.util.UUID;

public class PasswordResetEvent extends ApplicationEvent {

    public PasswordResetEvent(UUID userId) {
        super(userId);
    }

    public UUID getUserId() {
        return (UUID) source;
    }
}
