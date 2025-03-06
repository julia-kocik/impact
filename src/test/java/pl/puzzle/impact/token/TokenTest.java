package pl.puzzle.impact.token;

import org.junit.jupiter.api.Test;
import pl.puzzle.impact.common.exception.InvalidTokenException;
import java.time.LocalDateTime;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TokenTest {

    @Test
    void shouldReturnTrueWhenExpiryDateIsInTheFuture() {
        var token = Token.builder().expiryDate(LocalDateTime.now().plusMinutes(1)).build();

        assertTrue(token.isValid());
    }

    @Test
    void shouldReturnFalseWhenExpiryDateIsInThePast() {
        var token = Token.builder().expiryDate(LocalDateTime.now().minusMinutes(1)).build();

        assertFalse(token.isValid());
    }

    @Test
    void shouldReturnUserIdIfExpiryDateIsInTheFuture() {
        var userId = UUID.randomUUID();
        var token = Token.builder()
                .userId(userId)
                .expiryDate(LocalDateTime.now().plusMinutes(1))
                .build();

        assertEquals(userId, token.getUserIdIfValid());
    }

    @Test
    void shouldThrowExceptionIfExpiryDateIsInThePast() {
        var userId = UUID.randomUUID();
        var token = Token.builder()
                .userId(userId)
                .expiryDate(LocalDateTime.now().minusMinutes(1))
                .build();

        assertThrows(InvalidTokenException.class, token::getUserIdIfValid);
    }
}