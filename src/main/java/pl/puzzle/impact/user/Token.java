package pl.puzzle.impact.user;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name="token")
@NoArgsConstructor(access = PRIVATE, force = true)
@AllArgsConstructor(access = PRIVATE)
@Builder
@Getter
public class Token {
    @Id
    private final UUID id;

    private final UUID userId;

    private final String tokenCode;

    private final LocalDateTime expiryDate;

    @Enumerated(EnumType.STRING)
    private TokenType type;

    public static Token createToken(UUID userId, TokenType type) {
        return Token.builder()
                .id(UUID.randomUUID())
                .userId(userId)
                .tokenCode(UUID.randomUUID().toString().replace("-", ""))
                .expiryDate(LocalDateTime.now().plusMinutes(10))
                .type(type)
                .build();
    }
}
