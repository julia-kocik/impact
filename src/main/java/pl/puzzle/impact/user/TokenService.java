package pl.puzzle.impact.user;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class TokenService {
    private final TokenRepository tokenRepository;

    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public Token sendToken(UUID userId, TokenType type) {

        Token token = Token.createToken(userId, type);
        tokenRepository.save(token);
        //send email with link and token as its part
        return token;
    }

    public boolean validateToken(String tokenCode) {
        Optional<Token> tokenOpt = tokenRepository.findByTokenCode(tokenCode);
        if (tokenOpt.isEmpty()) {
            return false;
        }
        return !(LocalDateTime.now().isAfter(tokenOpt.get().getExpiryDate()));
    }
}
