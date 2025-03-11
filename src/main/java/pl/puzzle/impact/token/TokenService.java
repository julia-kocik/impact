package pl.puzzle.impact.token;

import org.springframework.stereotype.Service;
import pl.puzzle.impact.common.exception.ErrorMessage;
import pl.puzzle.impact.common.exception.NotFoundException;
import pl.puzzle.impact.token.dto.TokenRequest;
import java.util.Optional;
import java.util.UUID;

@Service
public class TokenService {

    private final TokenRepository tokenRepository;

    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public Token sendToken(TokenRequest request) {
        Token token = Token.createToken(request);
        tokenRepository.save(token);
        //TODO: send email with link and token as its part
        return token;
    }

    public UUID validateAndGetUserId(String tokenCode, TokenType type) {
        Optional<Token> tokenOpt = tokenRepository.findByTokenCodeAndType(tokenCode, type);

        if (tokenOpt.isEmpty()) {
            throw new NotFoundException(ErrorMessage.TOKEN_NOT_FOUND);
        }

        return tokenOpt.get().getUserIdIfValid();
    }

    public boolean validate(String tokenCode, TokenType type) {
        Optional<Token> tokenOpt = tokenRepository.findByTokenCodeAndType(tokenCode, type);
        return tokenOpt.map(Token::isValid).orElse(false);
    }
}
