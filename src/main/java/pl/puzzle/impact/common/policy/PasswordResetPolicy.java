package pl.puzzle.impact.common.policy;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.puzzle.impact.common.event.PasswordResetEvent;
import pl.puzzle.impact.token.TokenService;
import pl.puzzle.impact.token.dto.TokenRequest;

import static pl.puzzle.impact.token.TokenType.PASSWORD_RESET;

@Component
public class PasswordResetPolicy {

    private final TokenService tokenService;

    public PasswordResetPolicy(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @EventListener
    public void handlePasswordResetEvent(PasswordResetEvent event) {
        tokenService.sendToken(new TokenRequest(event.getUserId(), PASSWORD_RESET));
    }
}
